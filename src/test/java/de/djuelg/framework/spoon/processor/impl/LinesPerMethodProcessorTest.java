package de.djuelg.framework.spoon.processor.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.djuelg.domain.metric.result.BoxPlotMetricResult;
import de.djuelg.domain.metric.result.MetricResult;
import de.djuelg.domain.model.LinesPerMethod;

import java.util.List;
import java.util.stream.Collectors;

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
    public void process_createsResult() {
        LinesPerMethodProcessor processor = new LinesPerMethodProcessor();

        setupAndRun(processor);

        MetricResult result = processor.createMetricResult();
        assertNotNull(result);
    }

    @Test
    public void geMetricResult_containsLinesPerMethodResult() {
        LinesPerMethodProcessor processor = new LinesPerMethodProcessor();

        setupAndRun(processor);

        BoxPlotMetricResult result = processor.createMetricResult();
        List<LinesPerMethod> linesPerMethod = result.getDatapoints().stream().map(datapoint -> (LinesPerMethod) datapoint).collect(Collectors.toList());
        assertEquals("de.djuelg.neuronizer.domain.comparator.AlphabeticComparator", linesPerMethod.get(0).getQualifiedClassName());
        assertEquals("compare", linesPerMethod.get(0).getMethodName());
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