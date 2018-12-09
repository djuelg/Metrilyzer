package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class LinesPerClass {
    private final String qualifiedName;
    private final long lineCount;

    public LinesPerClass(String qualifiedName, long lineCount) {
        this.qualifiedName = qualifiedName;
        this.lineCount = lineCount;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public long getLineCount() {
        return lineCount;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", LinesPerClass.class.getSimpleName() + "[", "]")
                .add("qualifiedName='" + qualifiedName + "'")
                .add("lineCount=" + lineCount)
                .toString();
    }
}
