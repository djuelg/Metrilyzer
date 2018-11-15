package de.djuelg.domain.datastructure;

import java.util.Collection;

public class PackageDTO {

    private final String name;

    private final Collection<PackageDTO> packages;
    private final Collection<ClassDTO> classes;

    public PackageDTO(String name, Collection<PackageDTO> packages, Collection<ClassDTO> classes) {
        this.name = name;
        this.packages = packages;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public Collection<PackageDTO> getPackages() {
        return packages;
    }

    public Collection<ClassDTO> getClasses() {
        return classes;
    }
}
