package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.ParameterPerMethod;

import java.util.ArrayList;
import java.util.Collection;

public class ParameterPerMethodMetric extends Metric<ParameterPerMethod> {

    private static final String NAME = "Parameter per method";

    public ParameterPerMethodMetric() {
        this(NAME, new ArrayList<>());
    }

    public ParameterPerMethodMetric(String name, Collection<ParameterPerMethod> datapoints) {
        super(name, datapoints);
    }
}
