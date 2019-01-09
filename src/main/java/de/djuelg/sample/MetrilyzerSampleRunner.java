package de.djuelg.sample;

import de.djuelg.Metrilyzer;
import de.djuelg.domain.metric.MetricType;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MetrilyzerSampleRunner {

    private static final String INPUT_PROJECT_PATH = "/path/to/project";

    public static void main(String[] args) {
        Path inputProject = Paths.get(INPUT_PROJECT_PATH);
        Metrilyzer metrilyzer = Metrilyzer
                .fromProject(inputProject)
                .writeDiagramsTo(Paths.get(""))
                .build();

        metrilyzer.addMetric(MetricType.LINES_PER_CLASS);
        metrilyzer.addMetric(MetricType.LINES_PER_METHOD);
        metrilyzer.addMetric(MetricType.CLASS_PER_PACKAGE);
        metrilyzer.addMetric(MetricType.METHODS_PER_CLASSES);
        metrilyzer.addMetric(MetricType.PARAMETER_PER_METHOD);
        System.out.println("# " + INPUT_PROJECT_PATH + "\n");
        metrilyzer.run();
    }
}
