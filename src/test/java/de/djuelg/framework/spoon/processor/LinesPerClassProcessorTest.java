package de.djuelg.framework.spoon.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.djuelg.domain.metric.result.BoxPlotMetricResult;
import de.djuelg.domain.metric.result.MetricResult;
import de.djuelg.domain.model.LinesPerClass;

import java.util.List;
import java.util.stream.Collectors;

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
    public void process_createsResult() {
        LinesPerClassProcessor processor = new LinesPerClassProcessor();

        setupAndRun(processor);

        MetricResult result = processor.createMetricResult();
        assertNotNull(result);
    }

    @Test
    public void geMetricResult_containsLinesPerClassResult() {
        LinesPerClassProcessor processor = new LinesPerClassProcessor();

        setupAndRun(processor);

        BoxPlotMetricResult result = processor.createMetricResult();
        List<LinesPerClass> linesPerClasses = result.getDatapoints().stream().map(datapoint -> (LinesPerClass) datapoint).collect(Collectors.toList());
        assertEquals("de.djuelg.neuronizer.domain.interactors.note.impl.DisplayNoteInteractorImpl$1", linesPerClasses.get(0).getQualifiedName());
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