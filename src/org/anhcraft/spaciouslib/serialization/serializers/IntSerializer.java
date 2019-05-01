package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class IntSerializer extends DataType<Integer> {
    public IntSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{int.class,Integer.class};
    }

    @Override
    public Integer read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readInt();
    }

    @Override
    public void write(DataSerializerStream out, Integer data) throws IOException {
        out.writeInt(data);
    }
}