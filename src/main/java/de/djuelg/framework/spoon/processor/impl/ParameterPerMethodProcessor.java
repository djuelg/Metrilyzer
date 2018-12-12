package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.impl.ParameterPerMethodMetric;
import de.djuelg.domain.model.ParameterPerMethod;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

public class ParameterPerMethodProcessor extends MetricProcessor<CtMethod<?>> {

    private static final String SETTER_PREFIX = "set";
    private static final String GETTER_PREFIX = "get";

    private final ParameterPerMethodMetric metric;

    public ParameterPerMethodProcessor() {
        this(new ParameterPerMethodMetric());
    }

    public ParameterPerMethodProcessor(ParameterPerMethodMetric metric) {
        this.metric = metric;
    }

    @Override
    public void process(CtMethod<?> ctMethod) {
        if (isValid(ctMethod)) {
            String qualifiedClassName = ctMethod.getParent(CtClass.class).getQualifiedName();
            String methodName = ctMethod.getSimpleName();
            long parameterCount = ctMethod.getParameters().size();
            metric.addDatapoint(new ParameterPerMethod(qualifiedClassName, methodName, parameterCount));
        }
    }

    private boolean isValid(CtMethod<?> method) {
        return method.getParent(CtClass.class) != null
                && !method.getSimpleName().equals(method.getParent(CtClass.class).getSimpleName())
                && !method.getSimpleName().startsWith(SETTER_PREFIX)
                && !method.getSimpleName().startsWith(GETTER_PREFIX);
    }

    @Override
    public ParameterPerMethodMetric getMetric() {
        return metric;
    }
}
