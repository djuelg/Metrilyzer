package de.djuelg.domain;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;

import java.util.List;

public interface MetricRunner {

    void addMetric(Metric metric);

    List<MetricResult> runMetricsOnProject();
}
