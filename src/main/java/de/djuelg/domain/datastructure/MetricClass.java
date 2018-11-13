package de.djuelg.domain.datastructure;

import java.util.Collection;

public class MetricClass {

    private final String name;

    private final Collection<MetricClass> innerClasses;
    private final Collection<MetricMethod> methods;

    private final int nonJavaDocCommentCount;
    private final int fieldCount;
    private final int constantCount;
    private final int implementsCount;

    public MetricClass(String name, Collection<MetricClass> innerClasses, Collection<MetricMethod> methods, int nonJavaDocCommentCount, int fieldCount, int constantCount, int implementsCount) {
        this.name = name;
        this.innerClasses = innerClasses;
        this.methods = methods;
        this.nonJavaDocCommentCount = nonJavaDocCommentCount;
        this.fieldCount = fieldCount;
        this.constantCount = constantCount;
        this.implementsCount = implementsCount;
    }

    public String getName() {
        return name;
    }

    public Collection<MetricClass> getInnerClasses() {
        return innerClasses;
    }

    public Collection<MetricMethod> getMethods() {
        return methods;
    }

    public int getNonJavaDocCommentCount() {
        return nonJavaDocCommentCount;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public int getConstantCount() {
        return constantCount;
    }

    public int getImplementsCount() {
        return implementsCount;
    }
}
