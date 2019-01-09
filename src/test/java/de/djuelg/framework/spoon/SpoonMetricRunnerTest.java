package de.djuelg.framework.spoon;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.djuelg.domain.MetricRunner;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.MetricType;
import de.djuelg.domain.model.Datapoint;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class SpoonMetricRunnerTest {

    private static final String INPUT_PROJECT_PATH =  "src/test/resources/Neuronizer/main/";

    private final SpoonProcessors spoonProcessors = mock(SpoonProcessors.class);

    @Test
    public void testAddMetric_works() {
        MetricRunner metricRunner = new SpoonMetricRunner(Paths.get(INPUT_PROJECT_PATH));

        metricRunner.addMetric(MetricType.LINES_PER_CLASS);
    }

    @Test
    public void testAddMetric_savesMetric() {
        MetricRunner metricRunner = new SpoonMetricRunner(spoonProcessors);

        metricRunner.addMetric(MetricType.LINES_PER_CLASS);

        verify(spoonProcessors, times(1)).addProcessorFor(MetricType.LINES_PER_CLASS);
    }

    @Test
    public void testRunMetricOnProjects_returnsCollection() {
        MetricRunner metricRunner = new SpoonMetricRunner(Paths.get(INPUT_PROJECT_PATH));

        List<Metric<? extends Datapoint>> metrics = metricRunner.runMetricsOnProject();

        assertNotNull(metrics);
    }

    @Test
    public void testRunMetricOnProjectsWithMetric_callsSpoonProcessors() {
        MetricRunner metricRunner = new SpoonMetricRunner(spoonProcessors);

        metricRunner.addMetric(MetricType.LINES_PER_CLASS);
        List<Metric<? extends Datapoint>> metrics = metricRunner.runMetricsOnProject();

        verify(spoonProcessors, times(1)).run();
        verify(spoonProcessors, times(1)).results();
    }


}