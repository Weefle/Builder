package org.anhcraft.spaciouslib.utils;

import java.util.HashMap;

public class PrimitiveType {
    private static final HashMap<Class<?>, Class<?>> fromPrimitive = new HashMap<>();
    private static final HashMap<Class<?>, Class<?>> fromObject = new HashMap<>();

    static {
        put(byte.class, Byte.class);
        put(char.class, Character.class);
        put(short.class, Short.class);
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
        put(byte[].class, Byte[].class);
        put(char[].class, Character[].class);
        put(short[].class, Short[].class);
        put(int[].class, Integer[].class);
        put(double[].class, Double[].class);
        put(float[].class, Float[].class);
        put(long[].class, Long[].class);
        put(boolean[].class, Boolean[].class);
    }

    private static void put(Class<?> primitiveClass, Class<?> objectClass) {
        fromPrimitive.put(primitiveClass, objectClass);
        fromObject.put(objectClass, primitiveClass);
    }

    public static Class<?> getPrimitiveClass(Class<?> objectClass){
        return fromObject.get(objectClass);
    }

    public static Class<?> getObjectClass(Class<?> primitiveClass){
        return fromPrimitive.get(primitiveClass);
    }
}
