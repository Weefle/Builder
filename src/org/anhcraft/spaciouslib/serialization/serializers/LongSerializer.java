package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class LongSerializer extends DataType<Long> {
    public LongSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{long.class,Long.class};
    }

    @Override
    public Long read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readLong();
    }

    @Override
    public void write(DataSerializerStream out, Long data) throws IOException {
        out.writeLong(data);
    }
}