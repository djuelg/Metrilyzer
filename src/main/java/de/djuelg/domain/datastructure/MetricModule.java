package de.djuelg.domain.datastructure;

import java.util.Collection;

public class MetricModule {

    private final String name;

    private final Collection<MetricModule> subModules;
    private final Collection<MetricPackage> packages;

    public MetricModule(String name, Collection<MetricModule> subModules, Collection<MetricPackage> packages) {
        this.name = name;
        this.subModules = subModules;
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    public Collection<MetricModule> getSubModules() {
        return subModules;
    }

    public Collection<MetricPackage> getPackages() {
        return packages;
    }
}
