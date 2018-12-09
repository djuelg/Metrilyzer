package de.djuelg.domain;

import de.djuelg.domain.metric.Metric;

import java.util.List;

public interface MetricVisualizer {

    public void createDiagramsOf(List<Metric> results);
}
