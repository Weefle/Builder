package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.builders.ArrayBuilder;

import java.security.SecureRandom;
import java.util.List;
import java.util.Set;

/**
 * A utility class about randomization
 */
public class RandomUtils {
    private static final SecureRandom RANDOMIZER = new SecureRandom();
    private static final char[] ALPHA_CHARS = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * Picks a random element from the given set
     * @param set the set
     * @return a random element
     */
    public static <E> E pickRandom(Set<E> set) {
        if(set.size() == 0){
            return null;
        }
        return (E) set.toArray()[RANDOMIZER.nextInt(set.size())];
    }

    /**
     * Picks a random element from the given list
     * @param list the list
     * @return a random element
     */
    public static <E> E pickRandom(List<E> list) {
        if(list.size() == 0){
            return null;
        }
        return list.get(RANDOMIZER.nextInt(list.size()));
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static <E> E pickRandom(E[] array) {
        if(array.length == 0){
            return null;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static int pickRandom(int[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static char pickRandom(char[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static boolean pickRandom(boolean[] array) {
        if(array.length == 0){
            return false;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static short pickRandom(short[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static long pickRandom(long[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static double pickRandom(double[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static float pickRandom(float[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Picks a random element from the given array
     * @param array the array
     * @return a random element
     */
    public static byte pickRandom(byte[] array) {
        if(array.length == 0){
            return 0;
        }
        return array[RANDOMIZER.nextInt(array.length)];
    }

    /**
     * Generates a random integer from the minimum number to the maximum one
     * @param min the minimum number
     * @param max the maximum number
     * @return number
     */
    public static int randomInt(int min, int max){
        max++;
        return min + RANDOMIZER.nextInt(max-min);
    }

    /**
     * Generates a random real number from the minimum number to the maximum one
     * @param min the minimum number
     * @param max the maximum number
     * @return number
     */
    public static double randomDouble(double min, double max){
        return min + RANDOMIZER.nextDouble() * (max-min);
    }

    /**
     * Generates a random long number from the minimum number to the maximum one
     * @param min the minimum number
     * @param max the maximum number
     * @return number
     */
    public static double randomLong(long min, long max){
        return min + RANDOMIZER.nextLong() * (max-min);
    }

    /**
     * Generates a random short number from the minimum number to the maximum one
     * @param min the minimum number
     * @param max the maximum number
     * @return number
     */
    public static short randomShort(short min, short max){
        max++;
        return (short) (min + RANDOMIZER.nextInt(max-min));
    }

    /**
     * Generates a random string with the given string length
     * @param length length
     * @return generated string
     */
    public static String randomString(int length) {
        if(length <= 0){
            return "";
        }
        ArrayBuilder builder = new ArrayBuilder(char.class);
        for(int i = 0; i < length; i++){
            builder.append(pickRandom(ALPHA_CHARS));
        }
        return new String((char[]) builder.build());
    }

    /**
     * Generates a random string
     * @param length length
     * @param chars an array of characters which constitute a random string
     * @return generated string
     */
    public static String randomString(int length, char[] chars) {
        if(length <= 0 || chars.length == 0){
            return "";
        }
        ArrayBuilder builder = new ArrayBuilder(char.class);
        for(int i = 0; i < length; i++){
            builder.append(pickRandom(chars));
        }
        return new String((char[]) builder.build());
    }
}
