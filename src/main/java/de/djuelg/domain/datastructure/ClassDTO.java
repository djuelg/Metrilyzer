package de.djuelg.domain.datastructure;

import java.util.Collection;

public class ClassDTO {

    private final String name;

    private final Collection<ClassDTO> innerClasses;
    private final Collection<MethodDTO> methods;

    private final int nonJavaDocCommentCount;
    private final int fieldCount;
    private final int constantCount;
    private final int implementsCount;
    private final int lineCount;

    public ClassDTO(String name, Collection<ClassDTO> innerClasses, Collection<MethodDTO> methods, int nonJavaDocCommentCount, int fieldCount, int constantCount, int implementsCount, int lineCount) {
        this.name = name;
        this.innerClasses = innerClasses;
        this.methods = methods;
        this.nonJavaDocCommentCount = nonJavaDocCommentCount;
        this.fieldCount = fieldCount;
        this.constantCount = constantCount;
        this.implementsCount = implementsCount;
        this.lineCount = lineCount;
    }

    public String getName() {
        return name;
    }

    public Collection<ClassDTO> getInnerClasses() {
        return innerClasses;
    }

    public Collection<MethodDTO> getMethods() {
        return methods;
    }

    public int getNonJavaDocCommentCount() {
        return nonJavaDocCommentCount;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public int getConstantCount() {
        return constantCount;
    }

    public int getImplementsCount() {
        return implementsCount;
    }

    public int getLineCount() {
        return lineCount;
    }
}
