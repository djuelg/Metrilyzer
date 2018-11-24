package de.djuelg.domain;

import de.djuelg.domain.metric.result.MetricResult;

import java.util.List;

public interface MetricVisualizer {

    public void createDiagramsOf(List<MetricResult> results);
}
