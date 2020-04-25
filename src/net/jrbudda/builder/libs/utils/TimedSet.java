package net.jrbudda.builder.libs.utils;

import java.util.HashSet;

import net.jrbudda.builder.libs.annotations.Serializable;

/**
 * Represents a set which is able to clean its expired elements automatically.
 * @param <T> the data type of elements
 */
@Serializable
public class TimedSet<T> extends TimedCollection<T> {
    /**
     * Creates an empty timed set.
     */
    public TimedSet() {
        super(new HashSet<>());
    }

    /**
     * Clones the given timed set.
     * @param set timed set
     */
    public TimedSet(TimedSet<T> set) {
        super(set.data);
    }
}