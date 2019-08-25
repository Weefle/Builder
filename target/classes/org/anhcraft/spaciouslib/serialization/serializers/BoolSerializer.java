package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class BoolSerializer extends DataType<Boolean> {
    public BoolSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{boolean.class,Boolean.class};
    }

    @Override
    public Boolean read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readBoolean();
    }

    @Override
    public void write(DataSerializerStream out, Boolean data) throws IOException {
        out.writeBoolean(data);
    }
}
