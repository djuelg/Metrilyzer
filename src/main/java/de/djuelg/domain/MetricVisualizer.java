package de.djuelg.domain;

import de.djuelg.domain.metric.result.MetricResult;

import java.nio.file.Path;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MetricVisualizer {
    private final Path outputDirectory;

    public MetricVisualizer(Path outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public void createDiagramsOf(List<MetricResult> results) {
        throw new NotImplementedException();
    }
}
