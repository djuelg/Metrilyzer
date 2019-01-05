package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class MethodsPerClass {
    private final String qualifiedName;
    private final long methodCount;

    public MethodsPerClass(String qualifiedName, long methodCount) {
        this.qualifiedName = qualifiedName;
        this.methodCount = methodCount;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public long getMethodCount() {
        return methodCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodsPerClass that = (MethodsPerClass) o;
        return methodCount == that.methodCount &&
                Objects.equals(qualifiedName, that.qualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, methodCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MethodsPerClass.class.getSimpleName() + "[", "]")
                .add("qualifiedName='" + qualifiedName + "'")
                .add("methodCount=" + methodCount)
                .toString();
    }
}
