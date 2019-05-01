package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class CharSerializer extends DataType<Character> {
    public CharSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class<?>[]{char.class,Character.class};
    }

    @Override
    public Character read(DataMapping mapping, DataInputStream in) throws IOException {
        return in.readChar();
    }

    @Override
    public void write(DataSerializerStream out, Character data) throws IOException {
        out.writeChar(data);
    }
}
