package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.MethodsPerClass;

import java.util.ArrayList;
import java.util.Collection;

public class MethodsPerClassMetric extends Metric<MethodsPerClass> {

    private static final String NAME = "Methods per class";

    public MethodsPerClassMetric() {
        this(NAME, new ArrayList<>());
    }

    public MethodsPerClassMetric(String name, Collection<MethodsPerClass> datapoints) {
        super(name, datapoints);
    }
}
