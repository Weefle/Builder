package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class ByteSerializer extends DataType<Byte> {
    public ByteSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{byte.class,Byte.class};
    }

    @Override
    public Byte read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readByte();
    }

    @Override
    public void write(DataSerializerStream out, Byte data) throws IOException {
        out.writeByte(data);
    }
}
