package de.djuelg.domain.model;

public class LinesPerClass extends Datapoint {

    public LinesPerClass(String qualifiedName, long lineCount) {
        super(qualifiedName, lineCount);
    }
}