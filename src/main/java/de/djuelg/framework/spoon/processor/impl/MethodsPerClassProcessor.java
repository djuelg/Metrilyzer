package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.impl.MethodsPerClassMetric;
import de.djuelg.domain.model.MethodsPerClass;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import spoon.reflect.declaration.CtClass;

public class MethodsPerClassProcessor extends MetricProcessor<CtClass<?>> {

    private final MethodsPerClassMetric metric;

    public MethodsPerClassProcessor() {
        this(new MethodsPerClassMetric());
    }

    public MethodsPerClassProcessor(MethodsPerClassMetric metric) {
        this.metric = metric;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        String qualifiedName = ctClass.getQualifiedName();
        int methodCount = ctClass.getMethods().size();
        metric.addDatapoint(new MethodsPerClass(qualifiedName, methodCount));
    }

    @Override
    public MethodsPerClassMetric getMetric() {
        return metric;
    }
}
