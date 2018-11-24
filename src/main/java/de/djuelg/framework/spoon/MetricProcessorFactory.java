package de.djuelg.framework.spoon;

import de.djuelg.domain.metric.Metric;
import de.djuelg.framework.spoon.processor.LinesPerClassProcessor;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MetricProcessorFactory {

    public MetricProcessor getProcessor(Metric metric) {
        switch (metric) {
            case LINES_PER_CLASS:
                return new LinesPerClassProcessor();
                //throw new NotImplementedException();
                //break;
            case LINES_PER_METHOD:
                throw new NotImplementedException();
                //break;
            default:
                throw new IllegalArgumentException("Unknown Metric?!?!!!");
        }
    }
}
