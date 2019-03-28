package org.anhcraft.spaciouslib.serialization.serializers;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.builders.ArrayBuilder;
import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerialization;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;
import org.anhcraft.spaciouslib.utils.ExceptionThrower;
import org.anhcraft.spaciouslib.utils.Group;
import org.anhcraft.spaciouslib.utils.ReflectionUtils;

public class ObjectSerializer extends DataType<Object> {
    public ObjectSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class[0];
    }

    @Override
    public Object read(DataMapping mapping, DataInputStream in) throws IOException {
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(mapping.get(in.readUTF()));
            ExceptionThrower.ifFalse(clazz.isAnnotationPresent(Serializable.class),
                    new Exception("Class is not serializable"));

            // create new instance
            if(instanceProviders.containsKey(clazz.getName())) {
                obj = instanceProviders.get(clazz.getName()).run();
            } else {
                Constructor<?> cons = clazz.getConstructor();
                cons.setAccessible(true);
                obj = cons.newInstance();
            }

            ArrayBuilder array = new ArrayBuilder(Field.class);
            do {
                for(Field field : clazz.getDeclaredFields()) {
                    if(!Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(DataField.class)) {
                        array.append(field);
                    }
                }
                clazz = clazz.getSuperclass();
                if(!clazz.isAnnotationPresent(Serializable.class)) {
                    break;
                }
            } while(!clazz.equals(Object.class));

            Field[] fields = (Field[]) array.build();

            // get size of serialized fields
            int size = in.readInt();
            m:
            for(int i = 0; i < size; i++) {
                String name = in.readUTF();
                Object value = DataSerialization.lookupType(in.readByte()).read(mapping, in);

                // check each field
                for(Field field : fields) {
                    // if matches the current name or old names
                    if(field.getName().equals(name)) {
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();

                        // if the deserialized object is a collection, to apply it on the field, we must convert it into its real object
                        if(Collection.class.isAssignableFrom(fieldType)
                                && fieldType.getConstructors().length > 0) {
                            for(Constructor c : fieldType.getConstructors()) {
                                if(c.getParameterCount() == 1 &&
                                        c.getParameterTypes()[0].equals(Collection.class)) {
                                    field.set(obj, ReflectionUtils.getConstructor(fieldType,
                                            new Group<>(new Class<?>[]{Collection.class},
                                                    new Object[]{value}
                                            )));
                                    continue m;
                                }
                            }
                        }
                        // same as above, if the deserialized object is a map, to apply it on the field, we must convert it into its real object
                        else if(Map.class.isAssignableFrom(fieldType)
                                && fieldType.getConstructors().length > 0) {
                            for(Constructor c : fieldType.getConstructors()) {
                                if(c.getParameterCount() == 1 &&
                                        c.getParameterTypes()[0].equals(Map.class)) {
                                    field.set(obj, ReflectionUtils.getConstructor(fieldType,
                                            new Group<>(new Class<?>[]{Map.class},
                                                    new Object[]{value}
                                            )));
                                    continue m;
                                }
                            }
                        } else {
                            field.set(obj, value);
                        }
                    }
                }
            }
        } catch(InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void write(DataSerializerStream out, Object data) throws IOException {
        ExceptionThrower.ifNull(data, new IOException("The given object mustn't be null."));
        ExceptionThrower.ifFalse(data.getClass().isAnnotationPresent(Serializable.class), new IOException("The given object couldn't be serialized due to class ("+data.getClass().getName()+") wasn't serializable."));

        try {
            Class<?> clazz = data.getClass();
            out.writeUTF(clazz.getName());

            ArrayBuilder array = new ArrayBuilder(Field.class);
            do {
                for(Field field : clazz.getDeclaredFields()) {
                    if(!Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(DataField.class)) {
                        array.append(field);
                    }
                }
                clazz = clazz.getSuperclass();
                if(!clazz.isAnnotationPresent(Serializable.class)) {
                    break;
                }
            } while(!clazz.equals(Object.class));

            Field[] fields = (Field[]) array.build();
            out.writeInt(fields.length);
            for(Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(data);
                DataType<Object> type = value == null ? DataSerialization.lookupType(
                        field.getType()) : DataSerialization.lookupType(value.getClass());
                out.writeUTF(field.getName());
                out.writeByte(type.getIdentifier());
                type.write(out, field.get(data));
            }
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
