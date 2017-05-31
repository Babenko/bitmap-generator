package com.bmp.generator.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Sem Babenko.
 */
public class ArrayUtils {

    public static byte[] concat(byte[]... arrays) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(byte[] array : arrays) {
            try {
                baos.write(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return baos.toByteArray();
    }

    public static byte[] revers(byte[] source) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(int i = source.length - 1; i >= 0; i--) {
            baos.write(source[i]);
        }
        return baos.toByteArray();
    }

    public static byte[] getBytesValue(short val) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        return buffer.putShort(val).array();
    }

    public static byte[] getBytesValue(int val) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        return buffer.putInt(val).array();
    }
}
