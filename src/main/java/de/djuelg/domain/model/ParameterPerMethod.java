package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class ParameterPerMethod {
    private final String qualifiedClassName;
    private final String methodName;
    private final long parameterCount;

    public ParameterPerMethod(String qualifiedClassName, String methodName, long parameterCount) {
        this.qualifiedClassName = qualifiedClassName;
        this.methodName = methodName;
        this.parameterCount = parameterCount;
    }

    public String getQualifiedClassName() {
        return qualifiedClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public long getParameterCount() {
        return parameterCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterPerMethod that = (ParameterPerMethod) o;
        return parameterCount == that.parameterCount &&
                Objects.equals(qualifiedClassName, that.qualifiedClassName) &&
                Objects.equals(methodName, that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedClassName, methodName, parameterCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ParameterPerMethod.class.getSimpleName() + "[", "]")
                .add("qualifiedClassName='" + qualifiedClassName + "'")
                .add("methodName='" + methodName + "'")
                .add("parameterCount=" + parameterCount)
                .toString();
    }
}
