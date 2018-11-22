package de.djuelg.framework.exploration.spoon.test;

import static org.junit.Assert.assertEquals;

import de.djuelg.framework.exploration.spoon.processor.LinesPerClassProcessor;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class LinesPerClassProcessorTest {

    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
            "-o", "target/spooned/"
    };

    @Test
    public void testLinesPerClassProcessor_min() {
        final LinesPerClassProcessor processor = setupAndRunProcessor();
        assertEquals(6, processor.min());
    }

    @Test
    public void testLinesPerClassProcessor_q1() {
        final LinesPerClassProcessor processor = setupAndRunProcessor();
        assertEquals(7, processor.q1());
    }

    @Test
    public void testLinesPerClassProcessor_median() {
        final LinesPerClassProcessor processor = setupAndRunProcessor();
        assertEquals(21, processor.median());
    }

    @Test
    public void testLinesPerClassProcessor_q3() {
        final LinesPerClassProcessor processor = setupAndRunProcessor();
        assertEquals(59, processor.q3());
    }

    @Test
    public void testLinesPerClassProcessor_max() {
        final LinesPerClassProcessor processor = setupAndRunProcessor();
        assertEquals(458, processor.max());
    }

    private LinesPerClassProcessor setupAndRunProcessor() {
        final Launcher launcher = new Launcher();
        launcher.setArgs(LinesPerClassProcessorTest.ARGS);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        final LinesPerClassProcessor processor = new LinesPerClassProcessor();
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
        return processor;
    }
}