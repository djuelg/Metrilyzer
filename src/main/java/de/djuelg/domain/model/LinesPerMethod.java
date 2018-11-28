package de.djuelg.domain.model;

import de.djuelg.domain.metric.Datapoint;

import java.util.Objects;

public class LinesPerMethod implements Comparable<Datapoint>, Datapoint {
    private final String qualifiedClassName;
    private final String methodName;
    private final long lineCount;

    public LinesPerMethod(String qualifiedClassName, String methodName, long lineCount) {
        this.qualifiedClassName = qualifiedClassName;
        this.methodName = methodName;
        this.lineCount = lineCount;
    }

    public String getQualifiedClassName() {
        return qualifiedClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public Long datapoint() {
        return lineCount;
    }

    @Override
    public int compareTo(Datapoint other) {
        return Long.compare(this.datapoint(), other.datapoint());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinesPerMethod that = (LinesPerMethod) o;
        return lineCount == that.lineCount &&
                Objects.equals(qualifiedClassName, that.qualifiedClassName) &&
                Objects.equals(methodName, that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedClassName, methodName, lineCount);
    }
}
