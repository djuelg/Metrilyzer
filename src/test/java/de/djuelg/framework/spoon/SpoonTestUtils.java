package de.djuelg.framework.spoon;

import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.processing.Processor;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class SpoonTestUtils {

    private static final String[] ARGS = new String[]{
            "-i", "src/test/resources/Neuronizer/main/",
    };

    public static void setupAndRun(Processor processor) {
        setupAndRun(processor, ARGS);
    }

    public static void setupAndRun(Processor processor, String[] args) {
        final Launcher launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();

        final Factory factory = launcher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        processingManager.addProcessor(processor);
        processingManager.process(factory.Class().getAll());
    }
}
