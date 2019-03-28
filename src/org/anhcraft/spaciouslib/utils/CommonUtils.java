package org.anhcraft.spaciouslib.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {
    /**
     * Parses the given string as an integer safely.
     * @param number a number in string
     * @return the number
     */
    public static int toInteger(String number){
        return Integer.parseInt(number.replaceAll("[^\\d\\-]", ""));
    }

    /**
     * Parses the given string as a real number safely.
     * @param number a number in string
     * @return the number
     */
    public static double toRealNumber(String number){
        return Double.parseDouble(number.replaceAll("[^\\d\\-\\.]", ""));
    }

    /**
     * Encodes the given string into a base64 encoded string
     * @param str the string
     * @return base64 encoded string
     */
    public static String toBase64(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Decodes the given base64 encoded string into a string
     * @param str the base64 encoded string
     * @return the string
     */
    public static String fromBase64(String str) {
        return new String(Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
    }

    /**
     * Gets a object from the given array based on the string representation of the wanted object
     * @param a the string representation of a object which you want to get
     * @param array the array which contains that object
     * @return the object
     */
    public static <E> E getObject(String a, E[] array) {
        for(E x : array) {
            if(x.toString().equals(a)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Gets a object from the given list based on the string representation of the wanted object
     * @param a the string representation of a object which you want to get
     * @param list the list
     * @return the object
     */
    public static <E> E getObject(String a, List<E> list){
        for(E x : list){
            if(x.toString().equals(a)){
                return x;
            }
        }
        return null;
    }

    /**
     * Gets a object from the given set based on the string representation of the wanted object
     * @param a the string representation of a object which you want to get
     * @param set the set
     * @return the object
     */
    public static <E> E getObject(String a, Set<E> set){
        for(E x : set){
            if(x.toString().equals(a)){
                return x;
            }
        }
        return null;
    }

    /**
     * A simple method to check whether the given string is a valid JSON
     * @param json the string
     * @return true if yes
     */
    public static boolean isValidJSON(String json) {
        return RegEx.JSON.matches(json);
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static <E> E[] getPageItems(E[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        E[] filter = (E[]) Array.newInstance(all.getClass().getComponentType(), max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }


    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static byte[] getPageItems(byte[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        byte[] filter = (byte[]) Array.newInstance(byte.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static int[] getPageItems(int[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        int[] filter = (int[]) Array.newInstance(int.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static char[] getPageItems(char[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        char[] filter = (char[]) Array.newInstance(char.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static boolean[] getPageItems(boolean[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        boolean[] filter = (boolean[]) Array.newInstance(boolean.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static short[] getPageItems(short[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        short[] filter = (short[]) Array.newInstance(short.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static long[] getPageItems(long[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        long[] filter = (long[]) Array.newInstance(long.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static double[] getPageItems(double[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        double[] filter = (double[]) Array.newInstance(double.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given array of objects to each "page" based on the index
     *
     * @param all array of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static float[] getPageItems(float[] all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.length ? all.length : end;
        max = end-first;
        float[] filter = (float[]) Array.newInstance(float.class, max);
        int i = 0;
        while(i < max){
            filter[i] = all[i+first];
            i++;
        }
        return filter;
    }

    /**
     * Divides the given list of objects to each "page" based on the index
     *
     * @param all list of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static <E> List<E> getPageItems(List<E> all, int index, int max){
        int first = max * index;
        int end = max * index + max;
        end = end > all.size() ? all.size() : end;
        max = end-first;
        List<E> filter = new ArrayList<>();
        int i = 0;
        while(i < max){
            filter.add(all.get(i+first));
            i++;
        }
        return filter;
    }

    /**
     * Divides the given set of objects to each "page" based on the index
     *
     * @param all set of objects
     * @param index the index of "page" (start from 0)
     * @param max maximum amount of objects in each "page"
     * @return all objects in that "page"
     */
    public static <E> Set<E> getPageItems(Set<E> all, int index, int max){
        E[] all_ = (E[]) all.toArray();
        int first = max * index;
        int end = max * index + max;
        end = end > all.size() ? all.size() : end;
        max = end-first;
        Set<E> filter = new HashSet<>();
        int i = 0;
        while(i < max){
            filter.add(all_[i+first]);
            i++;
        }
        return filter;
    }

    /**
     * Converts a list to a new array
     * @param list list of elements
     * @param clazz the component type
     * @return the new array
     */
    public static <E> E[] toArray(List<E> list, Class clazz){
        return list.toArray((E[]) Array.newInstance(clazz, list.size()));
    }

    /**
     * Converts a set to a new array
     * @param set set of elements
     * @param clazz the component type
     * @return the new array
     */
    public static <E> E[] toArray(Set<E> set, Class clazz){
        return set.toArray((E[]) Array.newInstance(clazz, set.size()));
    }

    /**
     * Converts an array into a list
     * @param array an array
     * @return the new list
     */
    public static <E> List<E> toList(E[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    /**
     * Converts an array into a set
     * @param array an array
     * @return the new set
     */
    public static <E> Set<E> toSet(E[] array){
        return new HashSet<>(Arrays.asList(array));
    }

    /**
     * Creates a new UUID object from a UUID in string which doesn't have any dashes<br>
     * Source: https://stackoverflow.com/a/18987428
     * @return the UUID
     */
    public static UUID getUUIDWithoutDashes(String uuid){
        return UUID.fromString(uuid.replaceAll(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                "$1-$2-$3-$4-$5"));
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static <E> E[] shuffle(E[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            E temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static int[] shuffle(int[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static char[] shuffle(char[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static boolean[] shuffle(boolean[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            boolean temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static short[] shuffle(short[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            short temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static long[] shuffle(long[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            long temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static double[] shuffle(double[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            double temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static float[] shuffle(float[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            float temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in an array
     * @param array an array
     * @return an ordered array
     */
    public static byte[] shuffle(byte[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            byte temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Shuffles the order of elements in a list
     * @param list a list
     * @return an ordered list
     */
    public static <E> List<E> shuffle(List<E> list) {
        Collections.shuffle(list);
        return list;
    }

    /**
     * Shuffles the order of elements in a set
     * @param set a set
     * @return an ordered set
     */
    public static <E> Set<E> shuffle(Set<E> set) {
        return new HashSet<>(shuffle(new ArrayList<>(set)));
    }

    /**
     * Reverses the order of elements in a list
     * @param list a list
     * @return the reversed list
     */
    public static <E> List<E> reverse(List<E> list) {
        Collections.reverse(list);
        return list;
    }

    /**
     * Reverses the order of elements in a set
     * @param set a set
     * @return the reversed set
     */
    public static <E> Set<E> reverse(Set<E> set) {
        return new HashSet<>(reverse(new ArrayList<>(set)));
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static <E> E[] reverse(E[] array) {
        E[] narray = (E[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static int[] reverse(int[] array) {
        int[] narray = (int[]) Array.newInstance(int.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static char[] reverse(char[] array) {
        char[] narray = (char[]) Array.newInstance(char.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static boolean[] reverse(boolean[] array) {
        boolean[] narray = (boolean[]) Array.newInstance(boolean.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static short[] reverse(short[] array) {
        short[] narray = (short[]) Array.newInstance(short.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static long[] reverse(long[] array) {
        long[] narray = (long[]) Array.newInstance(long.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static double[] reverse(double[] array) {
        double[] narray = (double[]) Array.newInstance(double.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static float[] reverse(float[] array) {
        float[] narray = (float[]) Array.newInstance(float.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Reverses the order of elements in an array
     * @param array an array
     * @return the reversed array
     */
    public static byte[] reverse(byte[] array) {
        byte[] narray = (byte[]) Array.newInstance(byte.class, array.length);
        for(int i = 0; i < array.length; i++){
            narray[i] = array[array.length-i-1];
        }
        return narray;
    }

    /**
     * Compares two given objects
     * @param a the first object
     * @param b the second object
     * @return true if they're equal
     */
    public static boolean compare(Object a, Object b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.getClass().isArray()){
            if(b.getClass().isArray()){
                if(a.getClass().getComponentType().equals(b.getClass().getComponentType())){
                    if(Array.getLength(a) != Array.getLength(b)){
                        return false;
                    }
                    for(int i = 0; i < Array.getLength(a); i++){
                        if(!compare(Array.get(a, i), Array.get(b, i))){
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(!a.getClass().equals(b.getClass())){
            return false;
        }
        if(a instanceof String){
            return a.equals(b);
        }
        else if(a instanceof Integer){
            return ((Integer) a).intValue() == ((Integer) b).intValue();
        }
        else if(a instanceof Byte){
            return ((Byte) a).byteValue() == ((Byte) b).byteValue();
        }
        else if(a instanceof Float){
            return ((Float) a).floatValue() == ((Float) b).floatValue();
        }
        else if(a instanceof Short){
            return ((Short) a).shortValue() == ((Short) b).shortValue();
        }
        else if(a instanceof Long){
            return ((Long) a).longValue() == ((Long) b).longValue();
        }
        else if(a instanceof Double){
            return ((Double) a).doubleValue() == ((Double) b).doubleValue();
        }
        else if(a instanceof Character){
            return ((Character) a).charValue() == ((Character) b).charValue();
        }
        else if(a instanceof Boolean){
            return ((Boolean) a).booleanValue() == ((Boolean) b).booleanValue();
        } else {
            try {
                Field[] fields = ReflectionUtils.getAllFields(a.getClass());
                for(Field f : fields) {
                    f.setAccessible(true);
                    if(!Modifier.isStatic(f.getModifiers())) {
                        if(Object.class.isAssignableFrom(f.getType())) {
                            if(!compare(f.get(a), f.get(b))){
                                return false;
                            }
                        } else {
                            if(!compare(PrimitiveUtils.toObject(f.get(a), f.getType()), PrimitiveUtils.toObject(f.get(b), f.getType()))){
                                return false;
                            }
                        }
                    }
                }
            } catch(IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}