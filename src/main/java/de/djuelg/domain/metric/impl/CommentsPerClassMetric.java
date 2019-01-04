package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.CommentsPerClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommentsPerClassMetric extends Metric<CommentsPerClass> {

    private static final String NAME = "Comments per class";

    public CommentsPerClassMetric() {
        this(NAME, new ArrayList<>());
    }

    public CommentsPerClassMetric(String name, Collection<CommentsPerClass> datapoints) {
        super(name, datapoints);
    }

    public void addAll(List<CommentsPerClass> datapoints) {
        this.getDatapoints().addAll(datapoints);
    }
}
