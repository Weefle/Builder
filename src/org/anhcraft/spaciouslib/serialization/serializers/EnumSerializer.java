package org.anhcraft.spaciouslib.serialization.serializers;

import org.anhcraft.spaciouslib.serialization.DataMapping;
import org.anhcraft.spaciouslib.serialization.DataSerializerStream;
import org.anhcraft.spaciouslib.serialization.DataType;
import org.anhcraft.spaciouslib.utils.ExceptionThrower;

import java.io.DataInputStream;
import java.io.IOException;

public class EnumSerializer extends DataType<Enum<?>> {
    public EnumSerializer(byte id) {
        super(id);
    }

    @Override
    public Class<?>[] getClazz() {
        return new Class[0];
    }

    @Override
    public Enum<?> read(DataMapping mapping, DataInputStream in) throws IOException {
        String c = in.readUTF();
        try {
            return Enum.valueOf((Class<? extends Enum>) Class.forName(mapping.get(c)), in.readUTF());
        } catch(ClassNotFoundException e) {
            throw new IOException("Couldn't find the serialization class ("+c+")");
        }
    }

    @Override
    public void write(DataSerializerStream out, Enum<?> data) throws IOException {
        ExceptionThrower.ifNull(data, new IOException("The given enum mustn't be null."));
        out.writeUTF(data.getDeclaringClass().getName());
        out.writeUTF(data.name());
    }
}
