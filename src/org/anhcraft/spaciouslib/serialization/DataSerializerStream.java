package org.anhcraft.spaciouslib.serialization;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class DataSerializerStream implements DataOutput {
    private DataOutputStream outputStream;
    private StringBuilder log;

    public DataSerializerStream(DataOutputStream outputStream) {
        this.outputStream = outputStream;
        this.log = new StringBuilder();
    }

    public DataSerializerStream(OutputStream outputStream) {
        this.outputStream = new DataOutputStream(outputStream);
        this.log = new StringBuilder();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
        log.append(b).append(',');
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
        log.append(Arrays.toString(b)).append(',');
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
        log.append(Arrays.toString(b)).append('[').append(off).append(',').append(len).append(']').append(',');
    }

    @Override
    public void writeBoolean(boolean v) throws IOException {
        outputStream.writeBoolean(v);
        log.append(v).append(',');
    }

    @Override
    public void writeByte(int v) throws IOException {
        outputStream.writeByte(v);
        log.append(v).append(',');
    }

    @Override
    public void writeShort(int v) throws IOException {
        outputStream.writeShort(v);
        log.append(v).append(',');
    }

    @Override
    public void writeChar(int v) throws IOException {
        outputStream.writeChar(v);
        log.append(v).append(',');
    }

    @Override
    public void writeInt(int v) throws IOException {
        outputStream.writeInt(v);
        log.append(v).append(',');
    }

    @Override
    public void writeLong(long v) throws IOException {
        outputStream.writeLong(v);
        log.append(v).append(',');
    }

    @Override
    public void writeFloat(float v) throws IOException {
        outputStream.writeFloat(v);
        log.append(v).append(',');
    }

    @Override
    public void writeDouble(double v) throws IOException {
        outputStream.writeDouble(v);
        log.append(v).append(',');
    }

    @Override
    public void writeBytes(String s) throws IOException {
        outputStream.writeBytes(s);
        log.append(s).append(',');
    }

    @Override
    public void writeChars(String s) throws IOException {
        outputStream.writeChars(s);
        log.append(s).append(',');
    }

    @Override
    public void writeUTF(String s) throws IOException {
        outputStream.writeUTF(s);
        log.append(s).append(',');
    }

    public void close() throws IOException {
        outputStream.close();
    }

    public String getLog(){
        String str = log.toString();
        return str.substring(0, str.length()-1);
    }
}
