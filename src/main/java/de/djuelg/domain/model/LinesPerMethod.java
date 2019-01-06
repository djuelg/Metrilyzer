package de.djuelg.domain.model;

public class LinesPerMethod extends Datapoint {

    public LinesPerMethod(String qualifiedClassName, String methodName, long lineCount) {
        super(qualifiedClassName + ", \t" + methodName + "()", lineCount);
    }
}