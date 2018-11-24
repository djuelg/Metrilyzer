package de.djuelg.framework;

import de.djuelg.domain.MetricVisualizer;
import de.djuelg.domain.metric.result.MetricResult;

import java.nio.file.Path;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DummyMetricVisualizer implements MetricVisualizer {

    public DummyMetricVisualizer(Path path) {
        // TODO Find Library which creates plots
    }

    @Override
    public void createDiagramsOf(List<MetricResult> results) {
        throw new NotImplementedException();
    }
}
