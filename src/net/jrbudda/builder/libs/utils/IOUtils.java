package net.jrbudda.builder.libs.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class IOUtils {
    /**
     * Converts the given input stream into string
     * @param inputStream input stream object
     * @return string
     */
    public static String toString(InputStream inputStream){
        Scanner s = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Read the given URL into a string
     * @param url an URL
     * @return string
     */
    public static String toString(URL url){
        try {
            return toString(url.openConnection().getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converts the given input stream into a byte array
     * @param inputStream Input
     * @return an array of bytes
     */
    public static byte[] toByteArray(InputStream inputStream) {
        try {
            byte[] data = new byte[4096];
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            while((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            return buffer.toByteArray();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    /**
     * Converts the given input stream into a byte array
     * @param inputStream Input
     * @param progress an operation to be executed, the single argument represents for the amount of read byte
     * @return an array of bytes
     */
    public static byte[] toByteArray(InputStream inputStream, Consumer<Long> progress) {
        try {
            byte[] data = new byte[4096];
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            long read = 0;
            int nRead;
            while((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
                read += nRead;
                progress.accept(read);
            }

            return buffer.toByteArray();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    /**
     * Read the given URL into a byte array
     * @param url an URL
     * @return an array of bytes
     */
    public static byte[] toByteArray(URL url){
        try {
            return toByteArray(url.openConnection().getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    /**
     * Read the given URL into a byte array
     * @param url an URL
     * @param progress an operation to be executed, the single argument represents for the amount of read byte
     * @return an array of bytes
     */
    public static byte[] toByteArray(URL url, Consumer<Long> progress){
        try {
            return toByteArray(url.openConnection().getInputStream(), progress);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    /**
     * Copy the data from an input to an output.<br>
     * Notice that the stream will still be opened after then
     * @param in input
     * @param out output
     */
    public static void copy(InputStream in, OutputStream out){
        try {
            BufferedInputStream ins = new BufferedInputStream(in);
            BufferedOutputStream outs = new BufferedOutputStream(out);
            byte[] data = new byte[4096];
            int nRead;
            while((nRead = ins.read(data, 0, data.length)) != -1) {
                outs.write(data, 0, nRead);
            }
            outs.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy the data from an input to an output
     * @param in input
     * @param out output
     * @param close close the stream after finished or not
     */
    public static void copy(InputStream in, OutputStream out, boolean close){
        try {
            BufferedInputStream ins = new BufferedInputStream(in);
            BufferedOutputStream outs = new BufferedOutputStream(out);
            byte[] data = new byte[4096];
            int nRead;
            while((nRead = ins.read(data, 0, data.length)) != -1) {
                outs.write(data, 0, nRead);
            }
            outs.flush();
            if(close){
                in.close();
                out.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy the data from an input to an output.<br>
     * Notice that the stream will still be opened after then
     * @param in input
     * @param out output
     * @param progress an operation to be executed, the single argument represents for the amount of read byte
     */
    public static void copy(InputStream in, OutputStream out, Consumer<Long> progress){
        try {
            BufferedInputStream ins = new BufferedInputStream(in);
            BufferedOutputStream outs = new BufferedOutputStream(out);
            byte[] data = new byte[4096];
            long read = 0;
            int nRead;
            while((nRead = ins.read(data, 0, data.length)) != -1) {
                outs.write(data, 0, nRead);
                progress.accept(read);
                read += nRead;
            }
            outs.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy the data from an input to an output
     * @param in input
     * @param out output
     * @param progress an operation to be executed, the single argument represents for the amount of read byte
     * @param close close the stream after finished or not
     */
    public static void copy(InputStream in, OutputStream out, Consumer<Long> progress, boolean close){
        try {
            BufferedInputStream ins = new BufferedInputStream(in);
            BufferedOutputStream outs = new BufferedOutputStream(out);
            byte[] data = new byte[4096];
            long read = 0;
            int nRead;
            while((nRead = ins.read(data, 0, data.length)) != -1) {
                outs.write(data, 0, nRead);
                progress.accept(read);
                read += nRead;
            }
            outs.flush();
            if(close){
                in.close();
                out.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
