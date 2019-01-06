package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.ParameterPerMethodMetric;
import de.djuelg.domain.model.ParameterPerMethod;
import org.junit.Test;

public class ParameterPerMethodProcessorTest {
    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
    };

    @Test
    public void process_createsMetric() {
        ParameterPerMethodProcessor processor = new ParameterPerMethodProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetric_containsParameterPerMethodMetric() {
        ParameterPerMethodProcessor processor = new ParameterPerMethodProcessor();

        setupAndRun(processor);

        ParameterPerMethodMetric metric = processor.getMetric();
        ParameterPerMethod exprected = new ParameterPerMethod(
                "de.djuelg.neuronizer.AndroidApplication",
                "onCreate",
                0);

        metric.getDatapoints().stream().filter(v -> v.getNumber() > 5).forEach(System.out::println);

        assertTrue(metric.getDatapoints().contains(exprected));
    }
}