package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.LinesPerClassMetric;
import de.djuelg.domain.model.LinesPerClass;
import org.junit.Test;

public class LinesPerClassProcessorTest {

    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
    };

    @Test
    public void process_createsMetric() {
        LinesPerClassProcessor processor = new LinesPerClassProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetricResult_containsLinesPerClassMetric() {
        LinesPerClassProcessor processor = new LinesPerClassProcessor();

        setupAndRun(processor);

        LinesPerClassMetric metric = processor.getMetric();
        LinesPerClass exprected = new LinesPerClass(
                "de.djuelg.neuronizer.AndroidApplication",
                10);

        assertTrue(metric.getDatapoints().contains(exprected));
    }
}