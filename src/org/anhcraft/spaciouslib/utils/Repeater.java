package org.anhcraft.spaciouslib.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a repeating operation. The repeater is same as loop statement but has side-effects.
 * The repeater will return the result as a list of object.
 * @param <T> the type of objects
 */
public abstract class Repeater<T> {
    /**
     * Repeat an operation while the condition is true
     * @param init the initiation count
     * @param step the step count
     * @param repeater the repeater
     * @return a list of object
     */
    public static <T> List<T> whileTrue(int init, int step, Repeater<T> repeater){
        List<T> list = new ArrayList<>();
        int i = init;
        while(repeater.check(i)){
            list.add(repeater.run(i));
            i += step;
        }
        return list;
    }

    /**
     * Repeat an operation and stop when the condition is true.
     * @param init the initiation count
     * @param step the step count
     * @param repeater the repeater
     * @return a list of object
     */
    public static <T> List<T> until(int init, int step, Repeater<T> repeater){
        List<T> list = new ArrayList<>();
        int i = init;
        do {
            list.add(repeater.run(i));
            i += step;
        } while(!repeater.check(i));
        return list;
    }

    /**
     * Execute the operation by calling this method
     * @param current the current count
     * @return an object
     */
    public abstract T run(int current);

    /**
     * Check the given condition
     * @param current the current count
     * @return true or false
     */
    public abstract boolean check(int current);
}
