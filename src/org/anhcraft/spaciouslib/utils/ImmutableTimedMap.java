package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.annotations.Immutable;

/**
 * Represents an immutable map which is able to clean its expired entries automatically.
 * @param <K> the data type of keys
 * @param <V> the data type of values
 */
@Immutable
public class ImmutableTimedMap<K, V> extends TimedMap<K, V> {
    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void put(K key, V value, long aliveTime) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    @Deprecated
    public void remove(K key) {
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
    public void addAll(TimedMap<K, V> map) {
        throw new UnsupportedOperationException();
    }
}
