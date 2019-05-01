package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.annotations.Immutable;

import java.util.Collection;

@Immutable
public class ImmutableTimedCollection<T> extends TimedCollection<T> {
    ImmutableTimedCollection(Collection<Group<T, Long>> data) {
        super(data);
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void add(T elem, long aliveTime) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void remove(T elem) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void removeAt(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void addAll(TimedCollection<T> collection) {
        throw new UnsupportedOperationException();
    }
}
