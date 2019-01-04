package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.LinesPerMethodMetric;
import de.djuelg.domain.model.LinesPerMethod;
import org.junit.Test;

public class LinesPerMethodProcessorTest {
    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
    };

    @Test
    public void process_createsMetric() {
        LinesPerMethodProcessor processor = new LinesPerMethodProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetric_containsLinesPerMethodMetric() {
        LinesPerMethodProcessor processor = new LinesPerMethodProcessor();

        setupAndRun(processor);

        LinesPerMethodMetric metric = processor.getMetric();
        LinesPerMethod exprected = new LinesPerMethod(
                "de.djuelg.neuronizer.AndroidApplication",
                "onCreate",
                5);

        assertTrue(metric.getDatapoints().contains(exprected));
    }
}