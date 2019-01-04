package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class ClassesPerPackage {
    private final String qualifiedName;
    private final long classCount;

    public ClassesPerPackage(String qualifiedName, long classCount) {
        this.qualifiedName = qualifiedName;
        this.classCount = classCount;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public long getClassCount() {
        return classCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassesPerPackage that = (ClassesPerPackage) o;
        return classCount == that.classCount &&
                Objects.equals(qualifiedName, that.qualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, classCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClassesPerPackage.class.getSimpleName() + "[", "]")
                .add("qualifiedName='" + qualifiedName + "'")
                .add("classCount=" + classCount)
                .toString();
    }
}
