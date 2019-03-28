package org.anhcraft.spaciouslib.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.builders.EqualsBuilder;
import org.anhcraft.spaciouslib.builders.HashCodeBuilder;

/**
 * Represents a map which is able to clean its expired entries automatically.
 * @param <K> the data type of keys
 * @param <V> the data type of values
 */
@Serializable
public class TimedMap<K, V> {
    @DataField
    private HashMap<K, Group<V, Long>> data;

    public TimedMap() {
        this.data = new HashMap<>();
    }

    private boolean isExpired(long time) {
        return System.currentTimeMillis() >= time;
    }

    private void cleanExpiredElements() {
        data.entrySet().removeIf(pair -> isExpired(pair.getValue().getB()));
    }

    /**
     * Checks whether an entry was expired.
     * @param key entry's key
     * @return true if yes
     */
    public boolean isExpired(K key) {
        return !data.containsKey(key) || System.currentTimeMillis() >= data.get(key).getB();
    }

    /**
     * Gets the expiry time of an entry.
     * @param key entry's key
     * @return expiry time (may be -1 if the element is not existed)
     */
    public Long getExpiryTime(K key) {
        for(Map.Entry<K, Group<V, Long>> pair : data.entrySet()) {
            if(pair.getKey().equals(key)) {
                return pair.getValue().getB();
            }
        }
        return -1L;
    }

    /**
     * Returns the total number of entries.
     * @return the amount
     */
    public int size() {
        cleanExpiredElements();
        return data.size();
    }

    /**
     * Checks whether this map is empty.
     * @return true if yes
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Checks whether this map contains the given key.
     * @param key the key
     * @return true if yes
     */
    public boolean containsKey(K key) {
        cleanExpiredElements();
        return data.keySet().stream().anyMatch(k -> k.equals(key));
    }

    /**
     * Checks whether this map contains the given value.
     * @param value the value
     * @return true if yes
     */
    public boolean containsValue(V value) {
        cleanExpiredElements();
        return data.values().stream().anyMatch(k -> k.getA().equals(value));
    }

    /**
     * Puts the given entry.<br>
     * If there is an entry that has the same key, its value will be overridden instead.
     * @param key the key
     * @param value the value
     * @param aliveTime the alive time (in milliseconds)
     */
    public void put(K key, V value, long aliveTime) {
        cleanExpiredElements();
        data.put(key, new Group<>(value, System.currentTimeMillis()+aliveTime));
    }

    /**
     * Removes an entry.
     * @param key entry's key
     */
    public void remove(K key) {
        cleanExpiredElements();
        data.remove(key);
    }

    /**
     * Removes an entry at the given index.
     * @param index index
     */
    public void removeAt(int index) {
        cleanExpiredElements();
        Iterator<Map.Entry<K, Group<V, Long>>> it = data.entrySet().iterator();
        for(int i = 0; i <= index && it.hasNext(); i++){
            it.next();
        }
        it.remove();
    }

    /**
     * Returns an entry at the given index.
     * @param index index
     * @return element (or null if it is not existed)
     */
    public Map.Entry<K, V> getAt(int index){
        cleanExpiredElements();
        Map.Entry<K, Group<V, Long>> x = data.entrySet().stream().skip(index).findFirst().orElse(null);
        return new Map.Entry<K, V>() {
            @Override
            public K getKey() {
                return x.getKey();
            }

            @Override
            public V getValue() {
                return x.getValue().getA();
            }

            @Override
            public V setValue(V value) {
                V old = x.getValue().getA();
                x.getValue().setA(value);
                return old;
            }
        };
    }

    /**
     * Gets the value of an entry.
     * @param key entry's key
     */
    public V get(K key) {
        cleanExpiredElements();
        return data.get(key).getA();
    }

    /**
     * Clears this map.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Adds the given map to this one.
     * @param map map
     */
    public void addAll(TimedMap<K, V> map) {
        cleanExpiredElements();
        data.entrySet().addAll(map.data.entrySet());
    }

    /**
     * Returns the set of keys.
     */
    public Set<K> keySet(){
        cleanExpiredElements();
        return data.keySet();
    }

    /**
     * Returns the collection of values.
     */
    public Collection<V> values(){
        cleanExpiredElements();
        return data.values().stream().map(Group::getA).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o.getClass() == this.getClass()) {
            TimedMap m = (TimedMap) o;
            return new EqualsBuilder()
                    .append(m.data, this.data)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(21, 35)
                .append(this.data).append(this.data).build();
    }
}