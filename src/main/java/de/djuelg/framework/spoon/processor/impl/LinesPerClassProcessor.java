package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.impl.LinesPerClassMetric;
import de.djuelg.domain.model.LinesPerClass;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import spoon.reflect.declaration.CtClass;

public class LinesPerClassProcessor extends MetricProcessor<CtClass<?>> {

    private final LinesPerClassMetric metric;

    public LinesPerClassProcessor() {
        this(new LinesPerClassMetric());
    }

    public LinesPerClassProcessor(LinesPerClassMetric metric) {
        this.metric = metric;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        String qualifiedName = ctClass.getQualifiedName();
        long lineCount = extractLineCount(ctClass);
        metric.addDatapoint(new LinesPerClass(qualifiedName, lineCount));
    }

    private int extractLineCount(CtClass<?> ctClass) {
        return ctClass.toString().split("\r\n|\r|\n").length;
    }

    @Override
    public LinesPerClassMetric getMetric() {
        return metric;
    }
}
