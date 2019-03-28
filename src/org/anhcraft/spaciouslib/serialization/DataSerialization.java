package org.anhcraft.spaciouslib.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.anhcraft.spaciouslib.annotations.Immutable;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.serialization.providers.InstanceProvider;
import org.anhcraft.spaciouslib.serialization.serializers.BoolSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.ByteSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.CharSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.CollectionSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.DoubleSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.EnumSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.FloatSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.IntSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.LongSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.MapSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.ObjectArraySerializer;
import org.anhcraft.spaciouslib.serialization.serializers.ObjectSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.PrimitiveArraySerializer;
import org.anhcraft.spaciouslib.serialization.serializers.ShortSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.StringSerializer;
import org.anhcraft.spaciouslib.serialization.serializers.UUIDSerializer;
import org.anhcraft.spaciouslib.utils.ExceptionThrower;
import org.anhcraft.spaciouslib.utils.Group;
import org.anhcraft.spaciouslib.utils.Returner;

@SuppressWarnings(value = "unchecked")
public abstract class DataSerialization extends DataType {
    private static final int VERSION = 2;
    private static final HashMap<Class<?>, DataType> serializers = new HashMap<>();

    static {
        new ByteSerializer((byte) 0);
        new CharSerializer((byte) 1);
        new IntSerializer((byte) 2);
        new DoubleSerializer((byte) 3);
        new ShortSerializer((byte) 4);
        new FloatSerializer((byte) 5);
        new LongSerializer((byte) 6);
        new StringSerializer((byte) 7);
        new UUIDSerializer((byte) 8);
        new CollectionSerializer((byte) 9);
        new MapSerializer((byte) 10);
        new EnumSerializer((byte) 11);
        new BoolSerializer((byte) 12);

        // 30: ItemStack
        // 31: ItemMeta
        // 32: Location
        // 33: Vector
        // 34: NBTCompound
        // 35: Configuration

        serializers.put(boolean[].class, new PrimitiveArraySerializer((byte) 118, boolean.class));
        serializers.put(byte[].class, new PrimitiveArraySerializer((byte) 119, byte.class));
        serializers.put(char[].class, new PrimitiveArraySerializer((byte) 120, char.class));
        serializers.put(int[].class, new PrimitiveArraySerializer((byte) 121, int.class));
        serializers.put(double[].class, new PrimitiveArraySerializer((byte) 122, double.class));
        serializers.put(short[].class, new PrimitiveArraySerializer((byte) 123, short.class));
        serializers.put(float[].class, new PrimitiveArraySerializer((byte) 124, float.class));
        serializers.put(long[].class, new PrimitiveArraySerializer((byte) 125, long.class));
        serializers.put(Object[].class, new ObjectArraySerializer((byte) 126));
        new ObjectSerializer((byte) 127);
        new InstanceProvider().run();
    }

    protected DataSerialization() {
        super((byte) -1);
    }

    /**
     * Look up the accordant serializer for the given class type
     * @param clazz class type
     * @return the serializer
     */
    public static DataType<Object> lookupType(Class<?> clazz){
        DataType<Object> x = typeLookupById[127];
        if(clazz.isArray()){
            x = serializers.getOrDefault(clazz, typeLookupById[126]);
        } else if(clazz.isEnum()){
            x = typeLookupById[11];
        } else {
            for(Map.Entry<Class<?>, DataType> clasz : typeLookupByClass.entrySet()) {
                if(clasz.getKey().isAssignableFrom(clazz)) {
                    x = clasz.getValue();
                    break;
                }
            }
        }
        return x;
    }

    /**
     * Look up the serializer from its ID
     * @param id the ID
     * @return the serializer
     */
    public static DataType<Object> lookupType(byte id){
        return typeLookupById[id];
    }

    /**
     * Deserialize the given data into a specific object
     * @param byteArray array of bytes
     * @return the object
     */
    public static Object deserialize(byte[] byteArray) {
        return deserialize(new DataInputStream(new ByteArrayInputStream(byteArray)));
    }

    /**
     * Deserialize the given data into a specific object
     * @param byteArray array of bytes
     * @param mapping mapping of class names
     * @return the object
     */
    public static Object deserialize(byte[] byteArray, DataMapping mapping) {
        try {
            DataInputStream s = new DataInputStream(new ByteArrayInputStream(byteArray));
            Object o = deserialize(s, mapping);
            s.close();
            return o;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deserialize the given data into a specific object
     * @param inputStream an input stream
     * @return the object
     */
    public static Object deserialize(InputStream inputStream) {
        return deserialize(inputStream, new DataMapping());
    }

    /**
     * Deserialize the given data into a specific object
     * @param inputStream an input stream
     * @param mapping mapping of class names
     * @return the object
     */
    public static Object deserialize(InputStream inputStream, DataMapping mapping) {
        Object obj = null;
        try {
            DataInputStream in = new DataInputStream(inputStream);
            int v = in.readInt(); // version
            ExceptionThrower.ifFalse(v == VERSION, new Exception("Incorrect version. The process can't be started."));
            return DataSerialization.typeLookupById[127].read(mapping, in);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Serialize the given object
     * @param obj the object
     * @return a group of data and the working log
     */
    public static Group<byte[], String> serialize(Object obj) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try {
            DataSerializerStream out = serialize(obj, new DataSerializerStream(byteStream));
            out.close();
            return new Group<>(byteStream.toByteArray(), out.getLog());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new Group<>(byteStream.toByteArray(), null);
    }

    /**
     * Serialize the given object, then append the data into the existing data stream
     * @param obj the object
     * @param out data stream
     * @return current data stream
     */
    public static DataSerializerStream serialize(Object obj, DataSerializerStream out) {
        try {
            Class<?> clazz = obj.getClass();
            ExceptionThrower.ifFalse(clazz.isAnnotationPresent(Serializable.class),
                    new Exception("Class is not serializable"));
            ExceptionThrower.ifTrue(clazz.isAnnotationPresent(Immutable.class),
                    new Exception("Class is immutable"));
            out.writeInt(VERSION);
            DataSerialization.typeLookupById[127].write(out, obj);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * Registers the given instance provider
     * @param clazz the class which instances are created from
     * @param returner a returner for return instances
     */
    public static <T> void registerInstanceProvider(Class<? extends T> clazz, Returner<T> returner){
        instanceProviders.put(clazz.getName(), returner);
    }

    /**
     * Unregisters the given instance provider
     * @param clazz the class which instances are created from
     */
    public static <T> void unregisterInstanceProvider(Class<? extends T> clazz){
        instanceProviders.remove(clazz.getName());
    }
}
