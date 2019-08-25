package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleSerializer extends DataType<Double> {
    public DoubleSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{double.class,Double.class};
    }

    @Override
    public Double read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readDouble();
    }

    @Override
    public void write(DataSerializerStream out, Double data) throws IOException {
        out.writeDouble(data);
    }
}