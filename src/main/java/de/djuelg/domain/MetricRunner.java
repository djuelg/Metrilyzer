package de.djuelg.domain;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.MetricType;
import de.djuelg.domain.model.Datapoint;

import java.util.List;

public interface MetricRunner {

    void addMetric(MetricType metricType);

    List<Metric<? extends Datapoint>> runMetricsOnProject();
}
