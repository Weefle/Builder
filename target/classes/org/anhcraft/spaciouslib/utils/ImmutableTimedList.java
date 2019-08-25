package org.anhcraft.spaciouslib.utils;

import java.util.ArrayList;

/**
 * Represents an immutable list which is able to clean its expired elements automatically.
 * @param <T> the data type of elements
 */
public class ImmutableTimedList<T> extends ImmutableTimedCollection<T> {
    /**
     * Creates an empty immutable timed list.
     */
    public ImmutableTimedList() {
        super(new ArrayList<>());
    }

    /**
     * Clones the given immutable timed list.
     * @param list timed list
     */
    public ImmutableTimedList(ImmutableTimedList<T> list) {
        super(list.data);
    }

    /**
     * Clones the given timed list.
     * @param list timed list
     */
    public ImmutableTimedList(TimedSet<T> list) {
        super(list.data);
    }
}
