package de.djuelg.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class CommentsPerClass {
    private final String qualifiedName;
    private final long commentCount;

    public CommentsPerClass(String qualifiedName, long commentCount) {
        this.qualifiedName = qualifiedName;
        this.commentCount = commentCount;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public long getCommentCount() {
        return commentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsPerClass that = (CommentsPerClass) o;
        return commentCount == that.commentCount &&
                Objects.equals(qualifiedName, that.qualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, commentCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CommentsPerClass.class.getSimpleName() + "[", "]")
                .add("qualifiedName='" + qualifiedName + "'")
                .add("commentCount=" + commentCount)
                .toString();
    }
}
