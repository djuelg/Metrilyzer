package de.djuelg.framework.spoon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.MetricType;
import de.djuelg.framework.spoon.processor.MetricProcessor;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpoonProcessorsTest {

    private static final String INPUT_PROJECT_PATH =  "src/test/resources/Neuronizer/main/";

    private final MetricProcessorFactory factory = mock(MetricProcessorFactory.class);

    @Test
    public void testAddProcessorFor_addsProcessor() {
        List<MetricProcessor> processors = new ArrayList<>();
        SpoonProcessors spoonProcessors = new SpoonProcessors(Paths.get(INPUT_PROJECT_PATH), factory, processors);

        spoonProcessors.addProcessorFor(MetricType.LINES_PER_CLASS);

        assertEquals(1, processors.size());
    }

    @Test
    public void testRun_works() {
        List<MetricProcessor> processors = new ArrayList<>();
        SpoonProcessors spoonProcessors = new SpoonProcessors(Paths.get(INPUT_PROJECT_PATH), factory, processors);
        when(factory.getProcessor(any())).thenReturn(mock(MetricProcessor.class));

        spoonProcessors.addProcessorFor(MetricType.LINES_PER_CLASS);
        spoonProcessors.run();
    }

    @Test
    public void testResults_returnCollection() {
        List<MetricProcessor> processors = new ArrayList<>();
        SpoonProcessors spoonProcessors = new SpoonProcessors(Paths.get(INPUT_PROJECT_PATH), factory, processors);
        when(factory.getProcessor(any())).thenReturn(mock(MetricProcessor.class));

        spoonProcessors.run();

        List<Metric> results = spoonProcessors.results();
        assertNotNull(results);
        assertEquals(0, results.size());

    }

    @Test
    public void testResults_returnsFilledCollection() {
        List<MetricProcessor> processors = new ArrayList<>();
        SpoonProcessors spoonProcessors = new SpoonProcessors(Paths.get(INPUT_PROJECT_PATH), factory, processors);
        when(factory.getProcessor(any())).thenReturn(mock(MetricProcessor.class));

        spoonProcessors.addProcessorFor(MetricType.LINES_PER_CLASS);
        spoonProcessors.run();

        List<Metric> results = spoonProcessors.results();
        assertEquals(1, results.size());
    }


}