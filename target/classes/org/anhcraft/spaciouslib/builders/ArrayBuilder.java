package org.anhcraft.spaciouslib.builders;

import org.anhcraft.spaciouslib.utils.ExceptionThrower;
import org.anhcraft.spaciouslib.utils.PrimitiveType;
import org.anhcraft.spaciouslib.utils.ReflectionUtils;

import java.lang.reflect.Array;

public class ArrayBuilder {
    private Object array;
    private Class<?> clazz;
    private int size;

    public ArrayBuilder(Class<?> clazz){
        this.clazz = clazz;
        array = Array.newInstance(clazz, 0);
        size = 0;
    }

    public ArrayBuilder(Object array){
        ExceptionThrower.ifFalse(array.getClass().isArray(), new Exception("Object is not an array"));
        clazz = array.getClass().getComponentType();
        this.array = array;
        size = Array.getLength(array);
    }

    public ArrayBuilder append(Object obj){
        Object[] n = (Object[]) Array.newInstance(clazz, size+1);
        System.arraycopy(array, 0, n, 0, size);
        n[size] = obj;
        array = n;
        size++;
        return this;
    }

    public ArrayBuilder append(Object... objs){
        Object[] n = (Object[]) Array.newInstance(clazz, size+objs.length);
        System.arraycopy(array, 0, n, 0, size);
        System.arraycopy(objs, 0, n, size, objs.length);
        array = n;
        size += objs.length;
        return this;
    }


    public ArrayBuilder append(byte v){
        if(clazz.isAssignableFrom(byte.class)){
            byte[] n = (byte[]) Array.newInstance(byte.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(byte.class), v));
        }
    }

    public ArrayBuilder append(byte... bytes){
        if(clazz.isAssignableFrom(byte.class)) {
            byte[] n = (byte[]) Array.newInstance(byte.class, size + bytes.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(bytes, 0, n, size, bytes.length);
            array = n;
            size += bytes.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(byte.class);
            for(byte v : bytes){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(short v){
        if(clazz.isAssignableFrom(short.class)){
            short[] n = (short[]) Array.newInstance(short.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(short.class), v));
        }
    }

    public ArrayBuilder append(short... shorts){
        if(clazz.isAssignableFrom(short.class)) {
            short[] n = (short[]) Array.newInstance(short.class, size + shorts.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(shorts, 0, n, size, shorts.length);
            array = n;
            size += shorts.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(short.class);
            for(short v : shorts){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(int v){
        if(clazz.isAssignableFrom(int.class)){
            int[] n = (int[]) Array.newInstance(int.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(int.class), v));
        }
    }

    public ArrayBuilder append(int... ints){
        if(clazz.isAssignableFrom(int.class)) {
            int[] n = (int[]) Array.newInstance(int.class, size + ints.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(ints, 0, n, size, ints.length);
            array = n;
            size += ints.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(int.class);
            for(int v : ints){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(double v){
        if(clazz.isAssignableFrom(double.class)){
            double[] n = (double[]) Array.newInstance(double.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(double.class), v));
        }
    }

    public ArrayBuilder append(double... doubles){
        if(clazz.isAssignableFrom(double.class)) {
            double[] n = (double[]) Array.newInstance(double.class, size + doubles.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(doubles, 0, n, size, doubles.length);
            array = n;
            size += doubles.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(double.class);
            for(double v : doubles){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(float v){
        if(clazz.isAssignableFrom(float.class)){
            float[] n = (float[]) Array.newInstance(float.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(float.class), v));
        }
    }

    public ArrayBuilder append(float... floats){
        if(clazz.isAssignableFrom(float.class)) {
            float[] n = (float[]) Array.newInstance(float.class, size + floats.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(floats, 0, n, size, floats.length);
            array = n;
            size += floats.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(float.class);
            for(float v : floats){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(long v){
        if(clazz.isAssignableFrom(long.class)){
            long[] n = (long[]) Array.newInstance(long.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(long.class), v));
        }
    }

    public ArrayBuilder append(long... longs){
        if(clazz.isAssignableFrom(long.class)) {
            long[] n = (long[]) Array.newInstance(long.class, size + longs.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(longs, 0, n, size, longs.length);
            array = n;
            size += longs.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(long.class);
            for(long v : longs){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(boolean v){
        if(clazz.isAssignableFrom(boolean.class)){
            boolean[] n = (boolean[]) Array.newInstance(boolean.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(boolean.class), v));
        }
    }

    public ArrayBuilder append(boolean... booleans){
        if(clazz.isAssignableFrom(boolean.class)) {
            boolean[] n = (boolean[]) Array.newInstance(boolean.class, size + booleans.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(booleans, 0, n, size, booleans.length);
            array = n;
            size += booleans.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(boolean.class);
            for(boolean v : booleans){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public ArrayBuilder append(char v){
        if(clazz.isAssignableFrom(char.class)){
            char[] n = (char[]) Array.newInstance(char.class, size+1);
            System.arraycopy(array, 0, n, 0, size);
            n[size] = v;
            array = n;
            size++;
            return this;
        } else {
            return append(ReflectionUtils.cast(PrimitiveType.getObjectClass(char.class), v));
        }
    }

    public ArrayBuilder append(char... chars){
        if(clazz.isAssignableFrom(char.class)) {
            char[] n = (char[]) Array.newInstance(char.class, size + chars.length);
            System.arraycopy(array, 0, n, 0, size);
            System.arraycopy(chars, 0, n, size, chars.length);
            array = n;
            size += chars.length;
            return this;
        } else {
            Class<?> c = PrimitiveType.getObjectClass(char.class);
            for(char v : chars){
                append(ReflectionUtils.cast(c, v));
            }
            return this;
        }
    }

    public Object build(){
        return array;
    }

    public int length(){
        return size;
    }
}
