package de.djuelg.domain.datastructure;

public class MetricMethod {

    private final int parameterCount;
    private final int statementCount;
    private final int nestingDepthCount;

    public MetricMethod(int parameterCount, int statementCount, int nestingDepthCount) {
        this.parameterCount = parameterCount;
        this.statementCount = statementCount;
        this.nestingDepthCount = nestingDepthCount;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public int getStatementCount() {
        return statementCount;
    }

    public int getNestingDepthCount() {
        return nestingDepthCount;
    }
}
