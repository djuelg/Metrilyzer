package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.ClassesPerPackageMetric;
import de.djuelg.domain.model.ClassesPerPackage;
import org.junit.Test;

public class ClassesPerPackageProcessorTest {

    @Test
    public void process_createsMetric() {
        ClassesPerPackageProcessor processor = new ClassesPerPackageProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetricResult_containsCommentsPerClassMetric() {
        ClassesPerPackageProcessor processor = new ClassesPerPackageProcessor();

        setupAndRun(processor);

        ClassesPerPackageMetric metric = processor.getMetric();
        ClassesPerPackage exprected = new ClassesPerPackage(
                "de.djuelg.neuronizer.domain.model.preview",
                7);
        assertTrue(metric.getDatapoints().contains(exprected));
    }
}