package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.builders.EqualsBuilder;
import org.anhcraft.spaciouslib.builders.HashCodeBuilder;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Represents a collection which is able to clean its expired elements automatically.
 * @param <T> the type of elements
 */
@Serializable
public abstract class TimedCollection<T> implements Iterable<T> {
    @DataField
    protected Collection<Group<T, Long>> data;

    TimedCollection(Collection<Group<T, Long>> data) {
        this.data = data;
    }

    private boolean isExpired(long time) {
        return System.currentTimeMillis() >= time;
    }

    private void cleanExpiredElements() {
        data.removeIf(pair -> isExpired(pair.getB()));
    }

    /**
     * Checks whether an element was expired.
     * @param elem element
     * @return true if yes
     */
    public boolean isExpired(T elem) {
        for(Group<T, Long> pair : data) {
            if(pair.getA().equals(elem)) {
                return isExpired(pair.getB());
            }
        }
        return true;
    }

    /**
     * Gets the expiry time of the given element.
     * @param elem element
     * @return expiry time (may be -1 if the element is not existed)
     */
    public Long getExpiryTime(T elem) {
        for(Group<T, Long> pair : data) {
            if(pair.getA().equals(elem)) {
                return pair.getB();
            }
        }
        return -1L;
    }

    /**
     * Returns the total number of elements.
     * @return the amount
     */
    public int size() {
        cleanExpiredElements();
        return data.size();
    }

    /**
     * Checks whether this collection is empty.
     * @return true if yes
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Checks whether the given element is existed in this collection.
     * @param elem the element
     * @return true if yes
     */
    public boolean contains(T elem) {
        cleanExpiredElements();
        return data.stream().anyMatch(pair -> pair.getA().equals(elem));
    }

    /**
     * Adds the given element.
     * @param elem the element
     * @param aliveTime the alive time (in milliseconds)
     */
    public void add(T elem, long aliveTime) {
        cleanExpiredElements();
        data.add(new Group<>(elem, System.currentTimeMillis() + aliveTime));
    }

    /**
     * Removes all elements that equal with the given one.
     * @param elem the element
     */
    public void remove(T elem) {
        data.removeIf(pair -> isExpired(pair.getB()) || pair.getA().equals(elem));
    }

    /**
     * Removes an element at at the given index.
     * @param index index
     */
    public void removeAt(int index) {
        cleanExpiredElements();
        Iterator<Group<T, Long>> it = data.iterator();
        for(int i = 0; i <= index && it.hasNext(); i++){
            it.next();
        }
        it.remove();
    }

    /**
     * Find out an element at the given index.
     * @param index index
     * @return element (or null if it is not existed)
     */
    public T get(int index){
        cleanExpiredElements();
        return data.stream().skip(index).findFirst().orElse(null).getA();
    }

    /**
     * Clears this collection.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Adds the given collection to this one.
     * @param collection the timed collection
     */
    public void addAll(TimedCollection<T> collection) {
        cleanExpiredElements();
        this.data.addAll(collection.data);
    }

    /**
     * Returns the sequential {@code Stream} of this collection.
     * @return stream
     */
    public Stream<T> stream(){
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Returns the parallel {@code Stream} of this collection.
     * @return stream
     */
    public Stream<T> parallelStream(){
        return StreamSupport.stream(spliterator(), true);
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o.getClass() == this.getClass()) {
            TimedCollection m = (TimedCollection) o;
            return new EqualsBuilder()
                    .append(m.data, this.data)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(21, 33)
                .append(this.data).append(this.data).build();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int next = 0;
        private T current;

        @Override
        public boolean hasNext(){
            return next < size();
        }

        @Override
        public T next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = get(next);
            next++;
            return current;
        }

        @Override
        public void remove() {
            next--;
            removeAt(next);
        }
    }
}