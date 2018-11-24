package de.djuelg.domain.model;

import de.djuelg.domain.metric.Datapoint;

import java.util.Objects;

public class LinesPerClass implements Comparable<Datapoint>, Datapoint {
    private final String qualifiedName;
    private final long lineCount;

    public LinesPerClass(String qualifiedName, long lineCount) {
        this.qualifiedName = qualifiedName;
        this.lineCount = lineCount;
    }

    public String getQualifiedName() {
        return qualifiedName;
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
        LinesPerClass that = (LinesPerClass) o;
        return lineCount == that.lineCount &&
                Objects.equals(qualifiedName, that.qualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, lineCount);
    }
}
