package com.bmp.generator.entry.impl.bitmap;

import com.bmp.generator.entry.Header;
import com.bmp.generator.util.ArrayUtils;

import java.nio.ByteBuffer;

/**
 * @author Sem Babenko.
 */
class BitmapHeader implements Header {

    private final byte[] START = {0x42, 0x4d};

    private byte[] fileSize = new byte[4];

    private byte[] reservedPlace = new byte[4];

    private byte[] imageOffset = new byte[4];

    private byte[] informationalHeader = new byte[40];

    BitmapHeader() {
        informationalHeader[0] = 0x28;
        informationalHeader[8] = (byte)0xFE; // <- height
        informationalHeader[9] = (byte)0xFF; // <- height
        informationalHeader[10] = (byte)0xFF;
        informationalHeader[11] = (byte)0xFF;
        informationalHeader[12] = 0x01;
        informationalHeader[14] = 0x20;
        imageOffset[0] = 0x36;

    }

    void setFileSize(byte[] fileSize) {
        if (fileSize.length != 4) {
            throw new RuntimeException("Size should be 4 bytes");
        }
        System.arraycopy(fileSize, 0, this.fileSize, 0, fileSize.length);
    }

    void setWidth(int width) {
        byte[] convertedWidth = ArrayUtils.revers(ArrayUtils.getBytesValue((short)(width)));
        if(convertedWidth.length != 2) {
            throw new RuntimeException("Width should be 2 bytes");
        }
        System.arraycopy(convertedWidth, 0, this.informationalHeader, 4, convertedWidth.length);
    }

    void setHeight(int height) {
        short newHeight = (short)(0xFFFF - height + 1);
        byte[] convertedHeight = ArrayUtils.revers(ArrayUtils.getBytesValue(newHeight));
        if(convertedHeight.length != 2) {
            throw new RuntimeException("Height should be 2 bytes");
        }
        System.arraycopy(convertedHeight, 0, this.informationalHeader, 8, convertedHeight.length);
    }

    public byte[] toByteArray() {
        return ArrayUtils.concat(START, fileSize, reservedPlace, imageOffset, informationalHeader);
    }

}
