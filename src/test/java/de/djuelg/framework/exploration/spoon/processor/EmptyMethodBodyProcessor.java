package de.djuelg.framework.exploration.spoon.processor;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

/**
 * Reports warnings when empty methods are found.
 */
public class EmptyMethodBodyProcessor extends AbstractProcessor<CtMethod<?>> {

    public final List<CtMethod> emptyMethods = new ArrayList<CtMethod>();

    public void process(CtMethod<?> element) {
        if (element.getParent(CtClass.class) != null && !element.getModifiers().contains(ModifierKind.ABSTRACT) && element.getBody().getStatements().size() == 0) {
            emptyMethods.add(element);
        }
    }

}