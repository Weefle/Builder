package org.anhcraft.spaciouslib.serialization.serializers;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collections;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerialization;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

public class PrimitiveArraySerializer<I> extends DataType<I> {
    public Class<I> primitiveClass;

    public PrimitiveArraySerializer(byte id, Class<I> primitiveClass) {
        super(id);
        this.primitiveClass = primitiveClass;
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class[0];
    }

    @Override
    public I read(DataMapping mapping, DataInputStream in) throws IOException {
        int length = in.readInt();
        if(length > 0){
            I array = (I) Array.newInstance(primitiveClass, length);
            DataType type = DataSerialization.lookupType(primitiveClass);
            for(int i = 0; i < length; i++) {
                Array.set(array, i, type.read(mapping, in));
            }
            return array;
        }
        return (I) Array.newInstance(primitiveClass, 0);
    }

    @Override
    public void write(DataSerializerStream out, I data) throws IOException {
        int sz = Collections.singletonList(data).size();
        out.writeInt(sz);
        if(sz > 0) {
            DataType type = DataSerialization.lookupType(primitiveClass);
            for(int i = 0; i < sz; i++) {
                type.write(out, Array.get(data, i));
            }
        }
    }
}
