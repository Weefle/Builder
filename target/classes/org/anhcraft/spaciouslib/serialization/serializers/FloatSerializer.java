package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class FloatSerializer extends DataType<Float> {
    public FloatSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{float.class,Float.class};
    }

    @Override
    public Float read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readFloat();
    }

    @Override
    public void write(DataSerializerStream out, Float data) throws IOException {
        out.writeFloat(data);
    }
}