package org.anhcraft.spaciouslib.utils;

/**
 * Represents an operation that has output
 * @param <T> the type of the output
 */
public abstract class Returner<T> {
    public abstract T handle();

    /**
     * Executes the operation
     * @return the output
     */
    public T run(){
        return handle();
    }
}
