package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.LinesPerMethod;

import java.util.ArrayList;
import java.util.Collection;

public class LinesPerMethodMetric extends Metric<LinesPerMethod> {

    private static final String NAME = "Lines per method";

    public LinesPerMethodMetric() {
        this(NAME, new ArrayList<>());
    }

    public LinesPerMethodMetric(String name, Collection<LinesPerMethod> datapoints) {
        super(name, datapoints);
    }
}
