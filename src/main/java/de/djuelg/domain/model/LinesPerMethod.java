package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class LinesPerMethod {
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

    public long getLineCount() {
        return lineCount;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", LinesPerMethod.class.getSimpleName() + "[", "]")
                .add("qualifiedClassName='" + qualifiedClassName + "'")
                .add("methodName='" + methodName + "'")
                .add("lineCount=" + lineCount)
                .toString();
    }
}
