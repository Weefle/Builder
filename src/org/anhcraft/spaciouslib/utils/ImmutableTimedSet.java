package org.anhcraft.spaciouslib.utils;

import java.util.HashSet;

/**
 * Represents an immutable set which is able to clean its expired elements automatically.
 * @param <T> the data type of elements
 */
public class ImmutableTimedSet<T> extends ImmutableTimedCollection<T>{
    /**
     * Creates an empty immutable timed set.
     */
    public ImmutableTimedSet() {
        super(new HashSet<>());
    }

    /**
     * Clones the given immutable timed set.
     * @param set timed set
     */
    public ImmutableTimedSet(ImmutableTimedSet<T> set) {
        super(set.data);
    }

    /**
     * Clones the given timed set.
     * @param set timed set
     */
    public ImmutableTimedSet(TimedSet<T> set) {
        super(set.data);
    }
}
