package de.djuelg.framework.spoon;

import de.djuelg.domain.metric.MetricType;
import de.djuelg.framework.spoon.processor.MetricProcessor;
import de.djuelg.framework.spoon.processor.impl.ClassesPerPackageProcessor;
import de.djuelg.framework.spoon.processor.impl.CommentsPerClassProcessor;
import de.djuelg.framework.spoon.processor.impl.LinesPerClassProcessor;
import de.djuelg.framework.spoon.processor.impl.LinesPerMethodProcessor;
import de.djuelg.framework.spoon.processor.impl.MethodsPerClassProcessor;
import de.djuelg.framework.spoon.processor.impl.ParameterPerMethodProcessor;

public class MetricProcessorFactory {

    public MetricProcessor getProcessor(MetricType metricType) {
        switch (metricType) {
            case LINES_PER_CLASS:
                return new LinesPerClassProcessor();
            case LINES_PER_METHOD:
                return new LinesPerMethodProcessor();
            case COMMENTS_PER_CLASS:
                return new CommentsPerClassProcessor();
            case PARAMETER_PER_METHOD:
                return new ParameterPerMethodProcessor();
            case CLASS_PER_PACKAGE:
                return new ClassesPerPackageProcessor();
            case METHODS_PER_CLASSES:
                return new MethodsPerClassProcessor();
            default:
                throw new IllegalArgumentException(String.format("You forgot to add an initialization for type: %s", metricType));
        }
    }
}
