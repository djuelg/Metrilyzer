package de.djuelg.domain.model;

public class ParameterPerMethod extends Datapoint {

    public ParameterPerMethod(String qualifiedClassName, String methodName, long parameterCount) {
        super(qualifiedClassName + ", \t" + methodName + "()", parameterCount);
    }
}