package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class StringSerializer extends DataType<String> {
    public StringSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{String.class};
    }

    @Override
    public String read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readUTF();
    }

    @Override
    public void write(DataSerializerStream out, String data) throws IOException {
        out.writeUTF(data);
    }
};