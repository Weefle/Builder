package org.anhcraft.spaciouslib.utils;

public class PrimitiveUtils {
    public static <T> Object toObject(T primitive, Class<?> primitiveClass) {
        return ReflectionUtils.getConstructor(PrimitiveType.getObjectClass(primitiveClass), new Group<>(
                new Class<?>[]{primitiveClass},
                new Object[]{primitive}
        ));
    }
}
