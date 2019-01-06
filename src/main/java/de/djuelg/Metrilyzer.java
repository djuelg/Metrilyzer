package de.djuelg;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.MetricVisualizer;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.MetricType;
import de.djuelg.framework.RawConsoleOutputMetricVisualizer;
import de.djuelg.framework.spoon.SpoonMetricRunner;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

// todo check launchers e.g. MavenLauncher
// std launcher can be used ignoring libraries using setNoClasspath
// https://clean-code-developer.com/
// https://lumiera.org/project/background/CleanCodeDevelopment.html
// https://medium.com/mindorks/how-to-write-clean-code-lessons-learnt-from-the-clean-code-robert-c-martin-9ffc7aef870c
// https://dzone.com/articles/smells-in-java-code-do-you-recognize-them

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

    public void addMetric(MetricType metricType) {
        metricRunner.addMetric(metricType);
    }

    public void run() {
        List<Metric> results = metricRunner.runMetricsOnProject();
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
            MetricRunner metricRunner = new SpoonMetricRunner(Objects.requireNonNull(inputProject));
            MetricVisualizer metricVisualizer = new RawConsoleOutputMetricVisualizer(Objects.requireNonNull(outputDirectory));
            return new Metrilyzer(metricRunner, metricVisualizer);
        }
    }
}
