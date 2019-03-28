package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class UUIDSerializer extends DataType<UUID> {
    public UUIDSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{UUID.class};
    }

    @Override
    public UUID read(DataMapping mapping, DataInputStream in) throws IOException {
        return new UUID(in.readLong(), in.readLong());
    }

    @Override
    public void write(DataSerializerStream out, UUID data) throws IOException {
        out.writeLong(data.getMostSignificantBits());
        out.writeLong(data.getLeastSignificantBits());
    }
}