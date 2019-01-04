package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.impl.ClassesPerPackageMetric;
import de.djuelg.domain.model.ClassesPerPackage;
import de.djuelg.framework.spoon.processor.MetricProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;
import spoon.support.reflect.declaration.CtPackageImpl;

public class ClassesPerPackageProcessor extends MetricProcessor<CtClass<?>> {

    private final ClassesPerPackageMetric metric;
    private final Map<String, Integer> classCountMap;

    public ClassesPerPackageProcessor() {
        this(new ClassesPerPackageMetric());
    }

    public ClassesPerPackageProcessor(ClassesPerPackageMetric metric) {
        this.metric = metric;
        this.classCountMap = new HashMap<>();
    }

    @Override
    public void process(CtClass<?> ctClass) {
        CtElement parent = ctClass.getParent();
        while (!(parent instanceof CtPackageImpl) && parent != null) {
            parent = parent.getParent();
        }
        if (parent != null) {
            classCountMap.merge(((CtPackage) parent).getQualifiedName(), 1, (a, b) -> a + b);
        }
    }

    @Override
    public ClassesPerPackageMetric getMetric() {
        List<ClassesPerPackage> classesPerPackages = classCountMap.entrySet().stream()
                .map(entry -> new ClassesPerPackage(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        metric.addAll(classesPerPackages);
        return metric;
    }
}
