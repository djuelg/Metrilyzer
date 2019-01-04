package de.djuelg.framework.spoon.processor.impl;

import de.djuelg.domain.metric.impl.CommentsPerClassMetric;
import de.djuelg.domain.model.CommentsPerClass;
import de.djuelg.framework.spoon.processor.MetricProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.support.reflect.declaration.CtClassImpl;

public class CommentsPerClassProcessor extends MetricProcessor<CtComment> {

    private final CommentsPerClassMetric metric;
    private final Map<String, Integer> commentCountMap;

    public CommentsPerClassProcessor() {
        this(new CommentsPerClassMetric());
    }

    public CommentsPerClassProcessor(CommentsPerClassMetric metric) {
        this.metric = metric;
        this.commentCountMap = new HashMap<>();
    }

    @Override
    public void process(CtComment ctComment) {
        if (!ctComment.getCommentType().equals(CtComment.CommentType.JAVADOC)) {
            CtElement parent = ctComment.getParent();
            while (!(parent instanceof CtClassImpl) && parent != null) {
                parent = parent.getParent();
            }
            if (parent != null) {
                commentCountMap.merge(((CtClass<?>) parent).getQualifiedName(), 1, (a, b) -> a + b);
            }
        }
    }

    @Override
    public CommentsPerClassMetric getMetric() {
        List<CommentsPerClass> commentsPerClasses = commentCountMap.entrySet().stream()
                .map(entry -> new CommentsPerClass(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        metric.addAll(commentsPerClasses);
        return metric;
    }
}
