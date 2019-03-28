package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.annotations.Serializable;

import java.util.ArrayList;

/**
 * Represents a list which is able to clean its expired elements automatically.
 * @param <T> the data type of elements
 */
@Serializable
public class TimedList<T> extends TimedCollection<T> {
    /**
     * Creates an empty timed list.
     */
    public TimedList() {
        super(new ArrayList<>());
    }

    /**
     * Clones the given timed list.
     * @param list timed list
     */
    public TimedList(TimedList<T> list) {
        super(list.data);
    }
}