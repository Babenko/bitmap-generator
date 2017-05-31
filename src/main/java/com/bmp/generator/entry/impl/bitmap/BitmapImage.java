package com.bmp.generator.entry.impl.bitmap;

import com.bmp.generator.builder.ImageBuilder;
import com.bmp.generator.entry.Image;
import com.bmp.generator.util.ArrayUtils;

import java.util.Random;

/**
 * @author Sem Babenko.
 */
public class BitmapImage implements Image {

    private byte[] image;

    private byte[][] canvas;

    private BitmapHeader bitmapHeader;

    private int width;
    private int height;

    private int value;

    BitmapImage(){
        bitmapHeader = new BitmapHeader();
        setDefaultPixelSizeAndFill();
    }

    public byte[] getSource() {
        byte[] headerOutput = bitmapHeader.toByteArray();
        bitmapHeader.setFileSize(ArrayUtils.revers(ArrayUtils.getBytesValue(headerOutput.length + image.length + 1)));
        bitmapHeader.setWidth(width);
        bitmapHeader.setHeight(height);
        drawImage();
        return ArrayUtils.concat(bitmapHeader.toByteArray(), image, new byte[]{(byte)0xFF});
    }

    private void drawImage() {
        if(height > 0 && width > 0) {
            image = new byte[ width * 4 * height ]; // 4 is byte amount per pixel
            fillWithRandomPixels();
        }
    }

    private void setDefaultPixelSizeAndFill() {
        this.image = new byte[15];
        fillWithRandomPixels();
    }

    private void fillWithRandomPixels() {
        Random random = new Random();
        byte[] image = new byte[this.image.length + 1];
        for(int i = 1; i < image.length; i++) {
            if(i % 4 == 0 && i != 0) {
                image[i] = (byte) 0xFF;
            } else {
                image[i] = (byte)(127 - random.nextInt(255));
            }
        }
        System.arraycopy(image, 1, this.image, 0, image.length - 1);
    }

    static class BitmapBuilder implements ImageBuilder {

        private BitmapImage bmpImage;

        ImageBuilder prepare(BitmapImage bmpImage) {
            this.bmpImage = bmpImage;
            return this;
        }

        public ImageBuilder withValue(int val) {
            bmpImage.value = val;
            return this;
        }

        public ImageBuilder withWidth(int width) {
            bmpImage.width = width;
            return this;
        }

        public ImageBuilder withHeight(int height) {
            bmpImage.height = height;
            return this;
        }

        public Image build() {
            return bmpImage;
        }
    }
}
