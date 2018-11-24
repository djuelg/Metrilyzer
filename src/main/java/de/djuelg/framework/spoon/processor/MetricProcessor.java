package de.djuelg.framework.spoon.processor;

import de.djuelg.domain.metric.result.MetricResult;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;

public abstract class MetricProcessor<T extends CtType<?>> extends AbstractProcessor<T> {
    public abstract MetricResult geMetricResult();
}
