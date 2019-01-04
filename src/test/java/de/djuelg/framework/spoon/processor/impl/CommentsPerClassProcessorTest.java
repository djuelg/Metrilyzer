package de.djuelg.framework.spoon.processor.impl;

import static de.djuelg.framework.spoon.SpoonTestUtils.setupAndRun;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.metric.impl.CommentsPerClassMetric;
import de.djuelg.domain.model.CommentsPerClass;
import org.junit.Test;

public class CommentsPerClassProcessorTest {

    @Test
    public void process_createsMetric() {
        CommentsPerClassProcessor processor = new CommentsPerClassProcessor();

        setupAndRun(processor);

        Metric metric = processor.getMetric();
        assertNotNull(metric);
    }

    @Test
    public void geMetricResult_containsCommentsPerClassMetric() {
        CommentsPerClassProcessor processor = new CommentsPerClassProcessor();

        setupAndRun(processor);

        CommentsPerClassMetric metric = processor.getMetric();
        CommentsPerClass exprected = new CommentsPerClass(
                "de.djuelg.neuronizer.presentation.presenters.impl.DisplayPreviewPresenterImpl",
                8);
        assertTrue(metric.getDatapoints().contains(exprected));
    }
}