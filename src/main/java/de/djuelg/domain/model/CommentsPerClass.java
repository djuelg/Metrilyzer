package de.djuelg.domain.model;

public class CommentsPerClass extends Datapoint {

    public CommentsPerClass(String qualifiedName, long commentCount) {
        super(qualifiedName, commentCount);
    }
}