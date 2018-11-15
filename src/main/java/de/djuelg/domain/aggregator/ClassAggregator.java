package de.djuelg.domain.aggregator;

import de.djuelg.domain.datastructure.ClassDTO;
import de.djuelg.domain.datastructure.ModuleDTO;
import de.djuelg.domain.datastructure.PackageDTO;

import java.util.Collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ClassAggregator {
    public Collection<ClassDTO> aggregate(PackageDTO packageDTO) {
        throw new NotImplementedException();
    }

    public Collection<ClassDTO> aggregate(ModuleDTO moduleDTO) {
        throw new NotImplementedException();
    }
}
