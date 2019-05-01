package org.anhcraft.spaciouslib.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A utility class about compressing and decompressing data with GZIP format<br>
 * Source: <a href="https://stackoverflow.com/a/34305182">https://stackoverflow.com/a/34305182</a>
 */
public class GZipUtils {
    /**
     * Compresses the given byte array
     * @param data the byte array
     * @return the compressed byte array
     */
    public static byte[] compress(byte[] data) throws IOException {
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(data);
        gzip.flush();
        gzip.close();
        return obj.toByteArray();
    }

    /**
     * Decompresses the given compressed byte array
     * @param compressedData the compressed byte array
     * @return the byte array
     */
    public static byte[] decompress(final byte[] compressedData) throws IOException {
        if (isCompressed(compressedData)) {
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            return IOUtils.toByteArray(gis);
        }
        return new byte[512];
    }

    /**
     * Checks does the given byte array was compressed
     * @param compressedData the byte array
     * @return true if yes
     */
    public static boolean isCompressed(final byte[] compressedData) {
        return (compressedData[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressedData[1] == (byte) (GZIPInputStream
                .GZIP_MAGIC >> 8));
    }
}
