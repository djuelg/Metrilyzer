package de.djuelg.framework.spoon;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.MetricType;

import java.nio.file.Path;
import java.util.List;

public class SpoonMetricRunner implements MetricRunner {

    private final SpoonProcessors processors;

    public SpoonMetricRunner(Path inputProject) {
        this(new SpoonProcessors(inputProject));
    }

    public SpoonMetricRunner(SpoonProcessors processors) {
        this.processors = processors;
    }

    @Override
    public void addMetric(MetricType metricType) {
        processors.addProcessorFor(metricType);
    }

    @Override
    public List<Metric> runMetricsOnProject() {
        processors.run();
        return processors.results();
    }
}
