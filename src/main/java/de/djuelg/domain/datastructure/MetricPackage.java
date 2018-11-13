package de.djuelg.domain.datastructure;

import java.util.Collection;

public class MetricPackage {

    private final String name;

    private final Collection<MetricPackage> packages;
    private final Collection<MetricClass> classes;

    public MetricPackage(String name, Collection<MetricPackage> packages, Collection<MetricClass> classes) {
        this.name = name;
        this.packages = packages;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public Collection<MetricPackage> getPackages() {
        return packages;
    }

    public Collection<MetricClass> getClasses() {
        return classes;
    }
}
