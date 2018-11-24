package de.djuelg.framework.exploration.spoon.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import de.djuelg.framework.exploration.spoon.processor.EmptyMethodBodyProcessor;
import org.junit.Test;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class EmptyMethodBodyProcessorTest {

    @Test
    public void testEmptyMethodProcessor() {
        final String[] args = {
                "-i", "src/test/resources/mavenproject/src/",
                "-o", "target/spooned/"
        };

        final Launcher launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        final EmptyMethodBodyProcessor processor = new EmptyMethodBodyProcessor();
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());

        assertThat(processor.emptyMethods.size(), is(1));
    }
}