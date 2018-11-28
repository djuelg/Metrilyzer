package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.Datapoint;
import de.djuelg.domain.metric.result.BoxPlotMetricResult;
import de.djuelg.domain.model.LinesPerClass;
import de.djuelg.framework.spoon.processor.MetricProcessor;

import java.util.ArrayList;
import java.util.List;

import spoon.reflect.declaration.CtClass;

public class LinesPerClassProcessor extends MetricProcessor<CtClass<?>> {

    private final List<Datapoint> linesPerClasses;

    public LinesPerClassProcessor() {
        this(new ArrayList<>());
    }

    public LinesPerClassProcessor(List<Datapoint> linesPerClasses) {
        this.linesPerClasses = linesPerClasses;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        String qualifiedName = ctClass.getQualifiedName();
        long lineCount = extractLineCount(ctClass);
        linesPerClasses.add(new LinesPerClass(qualifiedName, lineCount));
    }

    private int extractLineCount(CtClass<?> ctClass) {
        return ctClass.toString().split("\r\n|\r|\n").length;
    }


    @Override
    public BoxPlotMetricResult createMetricResult() {
        return new BoxPlotMetricResult(linesPerClasses);
    }
}
