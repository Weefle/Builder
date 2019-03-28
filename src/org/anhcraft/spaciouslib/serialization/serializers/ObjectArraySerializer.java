package org.anhcraft.spaciouslib.serialization.serializers;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerialization;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

public class ObjectArraySerializer extends DataType<Object[]> {
    public ObjectArraySerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class[0];
    }

    @Override
    public Object[] read(DataMapping mapping, DataInputStream in) throws IOException {
        int length = in.readInt();
        try {
            Object[] array = (Object[]) Array.newInstance(Class.forName(mapping.get(in.readUTF())), length);
            for(int i = 0; i < length; i++) {
                array[i] = DataSerialization.lookupType(in.readByte()).read(mapping, in);
            }
            return array;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Object[0];
    }

    @Override
    public void write(DataSerializerStream out, Object[] data) throws IOException {
        out.writeInt(data.length);
        out.writeUTF(data.getClass().getComponentType().getName());
        for(Object d : data) {
            DataType type = DataSerialization.lookupType(d.getClass());
            out.writeByte(type.getIdentifier());
            type.write(out, d);
        }
    }
}
