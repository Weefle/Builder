package org.anhcraft.spaciouslib.utils;

import java.util.Collection;

public class ExceptionThrower {
    /**
     * Throws the given exception in case the expression is true
     * @param expression expression
     * @param exception exception
     */
    public static void ifTrue(boolean expression, Throwable exception){
        if(expression){
            try {
                throw exception;
            } catch(Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    /**
     * Throws the given exception in case the expression is false
     * @param expression expression
     * @param exception exception
     */
    public static void ifFalse(boolean expression, Throwable exception){
        ifTrue(!expression, exception);
    }

    /**
     * Throws the given exception in case the string is empty
     * @param string string
     * @param exception exception
     */
    public static void ifEmpty(String string, Throwable exception){
        ifTrue(string == null || string.length() == 0, exception);
    }

    /**
     * Throws the given exception in case the array is empty
     * @param array array
     * @param exception exception
     */
    public static <T> void ifEmpty(T[] array, Throwable exception){
        ifTrue(array.length == 0, exception);
    }

    /**
     * Throws the given exception in case the collection is empty
     * @param collection collection
     * @param exception exception
     */
    public static <E> void ifEmpty(Collection<E> collection, Throwable exception){
        ifTrue(collection.size() == 0, exception);
    }

    /**
     * Throws the given exception in case the string is not empty
     * @param string string
     * @param exception exception
     */
    public static void ifNotEmpty(String string, Throwable exception){
        ifTrue(string == null || string.length() > 0, exception);
    }

    /**
     * Throws the given exception in case the array is not empty
     * @param array array
     * @param exception exception
     */
    public static <T> void ifNotEmpty(T[] array, Throwable exception){
        ifTrue(array.length > 0, exception);
    }

    /**
     * Throws the given exception in case the collection is not empty
     * @param collection collection
     * @param exception exception
     */
    public static <E> void ifNotEmpty(Collection<E> collection, Throwable exception){
        ifTrue(collection.size() > 0, exception);
    }

    /**
     * Throws the given exception in case the object is null
     * @param obj object
     * @param exception exception
     */
    public static void ifNull(Object obj, Throwable exception){
        ifTrue(obj == null, exception);
    }

    /**
     * Throws the given exception in case the object is not null
     * @param obj object
     * @param exception exception
     */
    public static void ifNotNull(Object obj, Throwable exception){
        ifTrue(obj != null, exception);
    }
}
