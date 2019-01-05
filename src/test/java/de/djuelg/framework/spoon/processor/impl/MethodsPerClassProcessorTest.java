package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.MethodsPerClassMetric;
import de.djuelg.domain.model.MethodsPerClass;
import org.junit.Test;

public class MethodsPerClassProcessorTest {

    @Test
    public void process_createsMetric() {
        MethodsPerClassProcessor processor = new MethodsPerClassProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetricResult_containsLinesPerClassMetric() {
        MethodsPerClassProcessor processor = new MethodsPerClassProcessor();

        setupAndRun(processor);

        MethodsPerClassMetric metric = processor.getMetric();
        MethodsPerClass exprected = new MethodsPerClass(
                "de.djuelg.neuronizer.presentation.ui.dialog.BaseDialogs",
                6);

        assertTrue(metric.getDatapoints().contains(exprected));
    }
}