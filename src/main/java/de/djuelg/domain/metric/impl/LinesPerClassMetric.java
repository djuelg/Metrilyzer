package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.LinesPerClass;

import java.util.ArrayList;
import java.util.Collection;

public class LinesPerClassMetric extends Metric<LinesPerClass> {

    private static final String NAME = "Lines per class";

    public LinesPerClassMetric() {
        this(NAME, new ArrayList<>());
    }

    public LinesPerClassMetric(String name, Collection<LinesPerClass> datapoints) {
        super(name, datapoints);
    }
}
