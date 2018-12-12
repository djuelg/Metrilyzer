package de.djuelg.framework.spoon.processor.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.ParameterPerMethodMetric;
import de.djuelg.domain.model.ParameterPerMethod;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

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

        metric.getDatapoints().stream().filter(v -> v.getParameterCount() > 5).forEach(System.out::println);

        assertTrue(metric.getDatapoints().contains(exprected));
    }

    private void setupAndRun(ParameterPerMethodProcessor processor) {
        final Launcher launcher = new Launcher();
        launcher.setArgs(ARGS);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
    }
}