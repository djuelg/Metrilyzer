package de.djuelg.framework.spoon;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.result.MetricResult;
import de.djuelg.framework.spoon.processor.MetricProcessor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class SpoonProcessors {

    private final Path inputProject;
    private final MetricProcessorFactory processorFactory;
    private final List<MetricProcessor> processors;

    public SpoonProcessors(Path inputProject) {
        this(inputProject, new MetricProcessorFactory(), new ArrayList<>());
    }

    public SpoonProcessors(Path inputProject, MetricProcessorFactory processorFactory, List<MetricProcessor> processors) {
        this.inputProject = inputProject;
        this.processorFactory = processorFactory;
        this.processors = processors;
    }

    public void addProcessorFor(Metric metric) {
        MetricProcessor processor = processorFactory.getProcessor(metric);
        processors.add(processor);
    }

    public void run() {
        final Launcher spoonLauncher = initializeSpoonLauncher();
        final Factory factory = spoonLauncher.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager(factory);
        processMetrics(factory, processingManager);
    }

    private Launcher initializeSpoonLauncher() {
        final String[] args = { "-i", inputProject.toString() };
        final Launcher launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();
        return launcher;
    }

    private void processMetrics(Factory factory, ProcessingManager processingManager) {
        processors.forEach(processingManager::addProcessor);
        processingManager.process(factory.Class().getAll());
    }

    public List<MetricResult> results() {
        return processors.stream()
                .map(MetricProcessor::createMetricResult).collect(Collectors.toList());
    }
}