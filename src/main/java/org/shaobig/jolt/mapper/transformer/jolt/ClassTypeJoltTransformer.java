package org.shaobig.jolt.mapper.transformer.jolt;

import org.shaobig.jolt.mapper.transformer.classType.ClassTypeTransformer;
import org.shaobig.jolt.mapper.transformer.jolt.spec.JoltSpecTransformer;

public class ClassTypeJoltTransformer<T> extends JoltTransformer<T> {

    private ClassTypeTransformer<T> classTypeTransformer;

    public ClassTypeJoltTransformer(JoltSpecTransformer<Object> joltSpecTransformer, ClassTypeTransformer<T> classTypeTransformer) {
        super(joltSpecTransformer);
        this.classTypeTransformer = classTypeTransformer;
    }

    @Override
    public T transform(Object input) {
        return getClassTypeTransformer().transform(getJoltSpecTransformer().transform(input));
    }

    public ClassTypeTransformer<T> getClassTypeTransformer() {
        return classTypeTransformer;
    }

    public void setClassTypeTransformer(ClassTypeTransformer<T> classTypeTransformer) {
        this.classTypeTransformer = classTypeTransformer;
    }

}
