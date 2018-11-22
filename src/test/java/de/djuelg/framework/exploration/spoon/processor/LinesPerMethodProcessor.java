package de.djuelg.framework.exploration.spoon.processor;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

public class LinesPerMethodProcessor extends AbstractProcessor<CtMethod<?>> {

    private static final double FIRST_QUARTILE = 0.25;
    private static final double THIRD_QUARTILE = 0.75;
    private static final double MEDIAN = 0.5;

    private List<Long> sortedLineCountsOfMethods = new ArrayList<>();

    public long median() {
        return calculatePercentile(MEDIAN);
    }

    public long q1() {
        return calculatePercentile(FIRST_QUARTILE);
    }

    public long q3() {
        return calculatePercentile(THIRD_QUARTILE);
    }

    private Long calculatePercentile(double percentile) {
        int size = sortedLineCountsOfMethods.size();
        double q1 = sortedLineCountsOfMethods.stream()
                .mapToLong(item -> item)
                .skip((long) ((size-1)*percentile)).limit(2-size%2)
                .average().orElse(Double.NaN);
        return Math.round(q1);
    }

    public long min() {
        return sortedLineCountsOfMethods.stream().findFirst().orElseThrow(RuntimeException::new);
    }

    public long max() {
        return sortedLineCountsOfMethods.stream()
                .skip(sortedLineCountsOfMethods.size()-1)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public void process(CtMethod<?> method) {
        if (isValid(method)) {
            long lineCount = extractLineCount(method);
            sortedLineCountsOfMethods.add(lineCount);
            sortedLineCountsOfMethods.sort(null);
        }
    }

    private boolean isValid(CtMethod<?> method) {
        return method.getParent(CtClass.class) != null
                && !method.getModifiers().contains(ModifierKind.ABSTRACT)
                && !method.getSimpleName().startsWith("set")
                && !method.getSimpleName().startsWith("get");
    }

    private long extractLineCount(CtMethod<?> method) {
        return method.getBody().toString().split("\r\n|\r|\n").length - 2;

    }
}
