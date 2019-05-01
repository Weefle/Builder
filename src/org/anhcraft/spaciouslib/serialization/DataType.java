package org.anhcraft.spaciouslib.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.anhcraft.spaciouslib.utils.Returner;

public abstract class DataType<T> {
    protected static final HashMap<String, Returner> instanceProviders = new HashMap<>();
    private byte id;

    public byte getIdentifier(){
        return id;
    }

    public abstract Class<?>[] getClazz();
    public abstract T read(DataMapping mapping, DataInputStream in) throws IOException;
    public abstract void write(DataSerializerStream out, T data) throws IOException;

    static LinkedHashMap<Class<?>, DataType> typeLookupByClass = new LinkedHashMap<>();
    static DataType[] typeLookupById = new DataType[128];

    protected DataType(byte id) {
        this.id = id;
        typeLookupById[id] = this;
        for(Class<?> clazz : getClazz()) {
            typeLookupByClass.put(clazz, this);
        }
    }
}
