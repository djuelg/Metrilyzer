package de.djuelg.framework.spoon;

import de.djuelg.domain.metric.MetricType;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import de.djuelg.framework.spoon.processor.impl.LinesPerClassProcessor;
import de.djuelg.framework.spoon.processor.impl.LinesPerMethodProcessor;

public class MetricProcessorFactory {

    public MetricProcessor getProcessor(MetricType metricType) {
        switch (metricType) {
            case LINES_PER_CLASS:
                return new LinesPerClassProcessor();
            case LINES_PER_METHOD:
                return new LinesPerMethodProcessor();
            default:
                throw new IllegalArgumentException("Unknown Metric?!?!!!");
        }
    }
}
