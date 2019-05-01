package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class ShortSerializer extends DataType<Short> {
    public ShortSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{short.class,Short.class};
    }

    @Override
    public Short read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readShort();
    }

    @Override
    public void write(DataSerializerStream out, Short data) throws IOException {
        out.writeShort(data);
    }
}