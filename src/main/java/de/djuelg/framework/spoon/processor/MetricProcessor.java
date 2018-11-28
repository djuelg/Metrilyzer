package de.djuelg.framework.spoon.processor;

import de.djuelg.domain.metric.result.MetricResult;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;

public abstract class MetricProcessor<T extends CtElement> extends AbstractProcessor<T> {
    public abstract MetricResult createMetricResult();
}
