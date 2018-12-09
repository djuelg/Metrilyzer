package de.djuelg.framework.spoon.processor.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.LinesPerMethodMetric;
import de.djuelg.domain.model.LinesPerMethod;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

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

    private void setupAndRun(LinesPerMethodProcessor processor) {
        final Launcher launcher = new Launcher();
        launcher.setArgs(ARGS);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
    }
}