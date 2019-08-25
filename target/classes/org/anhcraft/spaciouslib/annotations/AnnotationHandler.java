package org.anhcraft.spaciouslib.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.anhcraft.spaciouslib.utils.ExceptionThrower;

public class AnnotationHandler {
    private static HashMap<Class, List<Object>> data = new HashMap<>();

    /**
     * Registers an object which is the environment for annotation handlers.
     * @param clazz class
     * @param object object
     */
    public static void register(Class clazz, Object object){
        ExceptionThrower.ifNull(clazz, new Exception("Class must not null"));
        List<Object> x = new ArrayList<>();
        if(data.containsKey(clazz)){
            x = data.get(clazz);
        }
        x.add(object);
        data.put(clazz, x);
    }

    /**
     * Unregisters the given class.
     * @param clazz class
     * @param object object
     */
    public static void unregister(Class clazz, Object object){
        ExceptionThrower.ifNull(clazz, new Exception("Class must not null"));
        List<Object> x = new ArrayList<>();
        if(data.containsKey(clazz)){
            x = data.get(clazz);
        }
        x.remove(object);
        data.put(clazz, x);
    }

    public static HashMap<Class, List<Object>> getClasses(){
        return new HashMap<>(data);
    }
}
