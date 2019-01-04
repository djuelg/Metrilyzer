package de.djuelg.domain.metric.impl;

import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.ClassesPerPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassesPerPackageMetric extends Metric<ClassesPerPackage> {

    private static final String NAME = "Classes per package";

    public ClassesPerPackageMetric() {
        this(NAME, new ArrayList<>());
    }

    public ClassesPerPackageMetric(String name, Collection<ClassesPerPackage> datapoints) {
        super(name, datapoints);
    }

    public void addAll(List<ClassesPerPackage> datapoints) {
        this.getDatapoints().addAll(datapoints);
    }

}
