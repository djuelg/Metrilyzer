package de.djuelg.framework.spoon;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class SpoonMetricRunnerTest {

    private static final String INPUT_PROJECT_PATH =  "src/test/resources/Neuronizer/main/";

    private final SpoonProcessors spoonProcessors = mock(SpoonProcessors.class);

    @Test
    public void testAddMetric_works() {
        MetricRunner metricRunner = new SpoonMetricRunner(Paths.get(INPUT_PROJECT_PATH));

        metricRunner.addMetric(Metric.LINES_PER_CLASS);
    }

    @Test
    public void testAddMetric_savesMetric() {
        MetricRunner metricRunner = new SpoonMetricRunner(spoonProcessors);

        metricRunner.addMetric(Metric.LINES_PER_CLASS);

        verify(spoonProcessors, times(1)).addProcessorFor(Metric.LINES_PER_CLASS);
    }

    @Test
    public void testRunMetricOnProjects_returnsCollection() {
        MetricRunner metricRunner = new SpoonMetricRunner(Paths.get(INPUT_PROJECT_PATH));

        List<MetricResult> metricResults = metricRunner.runMetricsOnProject();

        assertNotNull(metricResults);
    }

    @Test
    public void testRunMetricOnProjectsWithMetric_callsSpoonProcessors() {
        MetricRunner metricRunner = new SpoonMetricRunner(spoonProcessors);

        metricRunner.addMetric(Metric.LINES_PER_CLASS);
        List<MetricResult> metricResults = metricRunner.runMetricsOnProject();

        verify(spoonProcessors, times(1)).run();
        verify(spoonProcessors, times(1)).results();
    }


}