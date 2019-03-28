package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.builders.ArrayBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A class helps you to use reflection
 */
public class ReflectionUtils {
    public static Object cast(Class<?> clazz, Object castObj){
        return clazz.cast(castObj);
    }

    public static Object getEnum(String name, Class<?> clazz){
        return getStaticField(name, clazz);
    }

    public static Object getField(String field, Class<?> clazz, Object obj){
        try {
            Field f = clazz.getField(field);
            f.setAccessible(true);
            return f.get(obj);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getStaticField(String field, Class<?> clazz){
        try {
            Field f = clazz.getField(field);
            f.setAccessible(true);
            return f.get(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setField(String field, Class<?> clazz, Object obj, Object value){
        try {
            Field f = clazz.getField(field);
            f.setAccessible(true);
            f.set(obj, value);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setStaticField(String field, Class<?> clazz, Object value){
        try {
            Field f = clazz.getField(field);
            f.setAccessible(true);
            f.set(null, value);
        } catch(IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Object getStaticMethod(String method, Class<?> clazz, Group<Class<?>[], Object[]> args){
        try {
            Method f = clazz.getMethod(method, args.getA());
            f.setAccessible(true);
            return f.invoke(null, args.getB());
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getMethod(String method, Class<?> clazz, Object obj, Group<Class<?>[], Object[]> args){
        try {
            Method f = clazz.getMethod(method, args.getA());
            f.setAccessible(true);
            return f.invoke(obj, args.getB());
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getStaticMethod(String method, Class<?> clazz){
        try {
            Method f = clazz.getMethod(method);
            f.setAccessible(true);
            return f.invoke(null);
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getMethod(String method, Class<?> clazz, Object obj){
        try {
            Method f = clazz.getMethod(method);
            f.setAccessible(true);
            return f.invoke(obj);
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getConstructor(Class<?> clazz, Group<Class<?>[], Object[]> args){
        try {
            Constructor<?> f = clazz.getConstructor(args.getA());
            f.setAccessible(true);
            return f.newInstance(args.getB());
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getConstructor(Class<?> clazz){
        try {
            Constructor<?> f = clazz.getConstructor();
            f.setAccessible(true);
            return f.newInstance();
        } catch(InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        } catch(IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Field[] getAllFields(Class<?> clazz) {
        ArrayBuilder array = new ArrayBuilder(Field.class);
        do {
            array.append((Object[]) clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        } while(!clazz.equals(Object.class));
        return (Field[]) array.build();
    }
}
