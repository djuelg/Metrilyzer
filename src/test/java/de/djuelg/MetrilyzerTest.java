package de.djuelg;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.MetricVisualizer;
import de.djuelg.domain.metric.MetricType;
import de.djuelg.framework.spoon.SpoonMetricRunner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class MetrilyzerTest {

    private static final String INPUT_PROJECT_PATH =  "src/test/resources/Neuronizer/main/";
    private static final String METRIC_OUTPUT_PATH =  "target/metrics/";

    private MetricRunner metricRunner = mock(SpoonMetricRunner.class);
    private MetricVisualizer metricVisualizer = mock(MetricVisualizer.class);

    @Ignore("testApiUsage: Ignored until classes is implemented")
    @Test
    public void testApiUsage() {
        Path inputProject = Paths.get(INPUT_PROJECT_PATH);
        Path outputDirectory = Paths.get(METRIC_OUTPUT_PATH);
        Metrilyzer metrilyzer = Metrilyzer
                .fromProject(inputProject)
                .writeDiagramsTo(outputDirectory)
                .build();

        metrilyzer.addMetric(MetricType.LINES_PER_CLASS);
        metrilyzer.addMetric(MetricType.LINES_PER_METHOD);
        metrilyzer.run();
    }

    @Test
    public void testBuild_createsInstance() {
        Path inputProject = Paths.get(INPUT_PROJECT_PATH);
        Path outputDirectory = Paths.get(METRIC_OUTPUT_PATH);

        Metrilyzer metrilyzer = Metrilyzer
                .fromProject(inputProject)
                .writeDiagramsTo(outputDirectory)
                .build();

        assertNotNull(metrilyzer);
    }

    @Test
    public void testAddMetric_works() {
        Metrilyzer metrilyzer = new Metrilyzer(metricRunner, metricVisualizer);

        metrilyzer.addMetric(MetricType.LINES_PER_CLASS);

        verify(metricRunner, times(1)).addMetric(any());
    }

    @Test
    public void testRun_works() {
        Metrilyzer metrilyzer = new Metrilyzer(metricRunner, metricVisualizer);
        when(metricRunner.runMetricsOnProject()).thenReturn(new ArrayList<>());

        metrilyzer.addMetric(MetricType.LINES_PER_CLASS);
        metrilyzer.run();

        verify(metricRunner, times(1)).runMetricsOnProject();
        verify(metricVisualizer, times(1)).createDiagramsOf(any());
    }

}