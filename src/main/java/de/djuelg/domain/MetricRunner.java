package de.djuelg.domain;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;

import java.nio.file.Path;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MetricRunner {
    private final Path inputProject;

    public MetricRunner(Path inputProject) {
        this.inputProject = inputProject;
    }

    public void addMetric(Metric metric) {
        throw new NotImplementedException();
    }

    public List<MetricResult> runMetricsOnProject() {
        throw new NotImplementedException();
    }
}
