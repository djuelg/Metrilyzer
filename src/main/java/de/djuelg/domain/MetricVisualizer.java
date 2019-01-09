package de.djuelg.domain;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.Datapoint;

import java.util.List;

public interface MetricVisualizer {

    public void createDiagramsOf(List<Metric<? extends Datapoint>> results);
}
