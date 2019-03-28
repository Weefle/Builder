package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.builders.ArrayBuilder;

import java.util.function.Consumer;

/**
 * Represents an array splitter which splits the array into pages
 * @param <T> the type of elements
 */
public class Paginator<T> {
    private T[] data;
    private int length;
    private int current;
    private int slot;

    /**
     * Creates a new instance
     * @param data an array
     * @param slot the number of elements in each page
     */
    public Paginator(T[] data, int slot){
        this.data = data;
        this.length = data.length;
        this.slot = slot;
        this.current = 0;
    }

    /**
     * Creates a new instance
     * @param data an iterator
     * @param slot the number of elements in each page
     */
    public Paginator(Iterable<T> data, int slot){
        ArrayBuilder builder = new ArrayBuilder(Object.class);
        for(T e : data){
            builder.append(e);
        }
        this.data = (T[]) builder.build();
        this.length = this.data.length;
        this.slot = slot;
        this.current = 0;
    }

    /**
     * Goes to a page.<br>
     * Warning: Except for the first page, all accesses to unavailable pages (or empty ones) are not possible, and soon back to last page.
     * @param page the index of the page (from zero)
     * @return the destination page
     */
    public Paginator<T> go(int page){
        if(page < 0 || (empty() && page > 0)){
            current = pages()-1;
        } else {
            current = page;
        }
        return this;
    }

    /**
     * Goes to the next page.<br>
     * Warning: All accesses to unavailable pages (or empty ones) are not possible, and soon back to last page.
     * @return the next page
     */
    public Paginator<T> next(){
        return go(current+1);
    }

    /**
     * Goes to the previous page.<br>
     * Warning: Except for the first page, all accesses to unavailable pages (or empty ones) are not possible, and soon back to last page.
     * @return the previous page
     */
    public Paginator<T> prev(){
        return go(current-1);
    }

    /**
     * Check whether the current page is empty
     * @return true if yes
     */
    public boolean empty(){
        return current < 0 || current >= pages();
    }

    /**
     * Get all elements in the current page
     * @return an array of elements
     */
    public T[] get(){
        return CommonUtils.getPageItems(data, current, slot);
    }

    /**
     * Executes operation for each element in the current page
     * @param consumer consumer
     * @return this object
     */
    public Paginator<T> each(Consumer<T> consumer){
        for(T e : get()){
            consumer.accept(e);
        }
        return this;
    }

    /**
     * Count the number of pages
     * @return number of pages
     */
    public int pages(){
        int p = length/slot;
        return length % slot == 0 ? p : p+1;
    }

    /**
     * Get size of elements
     * @return size of elements
     */
    public int size(){
        return data.length;
    }

    /**
     * Get the current page index
     * @return current page index
     */
    public int current(){
        return current;
    }
}
