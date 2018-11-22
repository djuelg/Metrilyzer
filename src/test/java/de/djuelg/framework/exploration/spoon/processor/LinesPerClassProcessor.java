package de.djuelg.framework.exploration.spoon.processor;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

public class LinesPerClassProcessor extends AbstractProcessor<CtClass<?>> {

    private static final double FIRST_QUARTILE = 0.25;
    private static final double THIRD_QUARTILE = 0.75;
    private static final double MEDIAN = 0.5;

    private List<Long> sortedLineCountsOfClasses = new ArrayList<>();

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
        int size = sortedLineCountsOfClasses.size();
        double q1 = sortedLineCountsOfClasses.stream()
                .mapToLong(item -> item)
                .skip((long) ((size-1)*percentile)).limit(2-size%2)
                .average().orElse(Double.NaN);
        return Math.round(q1);
    }

    public long min() {
        return sortedLineCountsOfClasses.stream().findFirst().orElseThrow(RuntimeException::new);
    }

    public long max() {
        return sortedLineCountsOfClasses.stream()
                .skip(sortedLineCountsOfClasses.size()-1)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public void process(CtClass<?> ctClass) {
        long lineCount = extractLineCount(ctClass);
        sortedLineCountsOfClasses.add(lineCount);
        sortedLineCountsOfClasses.sort(null);
    }

    private int extractLineCount(CtClass<?> ctClass) {
        return ctClass.toString().split("\r\n|\r|\n").length;
    }
}
