package de.djuelg.framework.spoon;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;

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
    public void addMetric(Metric metric) {
        processors.addProcessorFor(metric);
    }

    @Override
    public List<MetricResult> runMetricsOnProject() {
        processors.run();
        return processors.results();
    }
}
