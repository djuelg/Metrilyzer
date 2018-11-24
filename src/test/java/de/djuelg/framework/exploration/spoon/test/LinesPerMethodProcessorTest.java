package de.djuelg.framework.exploration.spoon.test;

import static org.junit.Assert.assertEquals;

import de.djuelg.framework.exploration.spoon.processor.LinesPerMethodProcessor;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class LinesPerMethodProcessorTest {

    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
            "-o", "target/spooned/"
    };

    @Test
    public void testLinesPerMethodProcessor_min() {
        final LinesPerMethodProcessor processor = setupAndRunProcessor();
        assertEquals(1, processor.min());
    }

    @Test
    public void testLinesPerMethodProcessor_q1() {
        final LinesPerMethodProcessor processor = setupAndRunProcessor();
        assertEquals(1, processor.q1());
    }

    @Test
    public void testLinesPerMethodProcessor_median() {
        final LinesPerMethodProcessor processor = setupAndRunProcessor();
        assertEquals(2, processor.median());
    }

    @Test
    public void testLinesPerMethodProcessor_q3() {
        final LinesPerMethodProcessor processor = setupAndRunProcessor();
        assertEquals(7, processor.q3());
    }

    @Test
    public void testLinesPerMethodProcessor_max() {
        final LinesPerMethodProcessor processor = setupAndRunProcessor();
        assertEquals(57, processor.max());
    }

    private LinesPerMethodProcessor setupAndRunProcessor() {
        final Launcher launcher = new Launcher();
        launcher.setArgs(LinesPerMethodProcessorTest.ARGS);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        final LinesPerMethodProcessor processor = new LinesPerMethodProcessor();
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
        return processor;
    }
}