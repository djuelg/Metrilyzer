package de.djuelg.framework.spoon.processor;

import de.djuelg.domain.metric.result.MetricResult;
import spoon.reflect.declaration.CtClass;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LinesPerClassProcessor extends MetricProcessor<CtClass<?>> {

    @Override
    public MetricResult geMetricResult() {
        throw new NotImplementedException();
    }

    @Override
    public void process(CtClass<?> element) {
        throw new NotImplementedException();
    }
}
