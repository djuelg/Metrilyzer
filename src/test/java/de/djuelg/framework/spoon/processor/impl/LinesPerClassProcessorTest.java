package de.djuelg.framework.spoon.processor.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.LinesPerClassMetric;
import de.djuelg.domain.model.LinesPerClass;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

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

    private void setupAndRun(LinesPerClassProcessor processor) {
        final Launcher launcher = new Launcher();
        launcher.setArgs(LinesPerClassProcessorTest.ARGS);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
    }
}