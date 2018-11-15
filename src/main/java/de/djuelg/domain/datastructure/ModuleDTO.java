package de.djuelg.domain.datastructure;

import java.util.Collection;

public class ModuleDTO {

    private final String name;

    private final Collection<ModuleDTO> subModules;
    private final Collection<PackageDTO> packages;

    public ModuleDTO(String name, Collection<ModuleDTO> subModules, Collection<PackageDTO> packages) {
        this.name = name;
        this.subModules = subModules;
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    public Collection<ModuleDTO> getSubModules() {
        return subModules;
    }

    public Collection<PackageDTO> getPackages() {
        return packages;
    }
}
