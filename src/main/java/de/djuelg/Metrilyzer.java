package de.djuelg;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.MetricVisualizer;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Metrilyzer {

    private final MetricRunner metricRunner;
    private final MetricVisualizer metricVisualizer;

    public static MetrilyzerBuilder fromProject(Path inputProject) {
        return new MetrilyzerBuilder(inputProject);
    }

    public Metrilyzer(MetricRunner metricRunner, MetricVisualizer metricVisualizer) {
        this.metricRunner = metricRunner;
        this.metricVisualizer = metricVisualizer;
    }

    public void addMetric(Metric metric) {
        metricRunner.addMetric(metric);
    }

    public void run() {
        List<MetricResult> results = metricRunner.runMetricsOnProject();
        metricVisualizer.createDiagramsOf(results);
    }




    public static class MetrilyzerBuilder {

        private Path inputProject;
        private Path outputDirectory;

        protected MetrilyzerBuilder(Path inputProject) {
            this.inputProject = inputProject;
        }

        public MetrilyzerBuilder writeDiagramsTo(Path outputDirectory) {
            this.outputDirectory = outputDirectory;
            return this;
        }

        public Metrilyzer build() {
            MetricRunner metricRunner = new MetricRunner(Objects.requireNonNull(inputProject));
            MetricVisualizer metricVisualizer = new MetricVisualizer(Objects.requireNonNull(outputDirectory));
            return new Metrilyzer(metricRunner, metricVisualizer);
        }
    }
}
