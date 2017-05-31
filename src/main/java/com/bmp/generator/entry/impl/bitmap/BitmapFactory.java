package com.bmp.generator.entry.impl.bitmap;

import com.bmp.generator.builder.ImageBuilder;
import com.bmp.generator.factory.ImageFactory;

/**
 * @author Sem Babenko.
 */
public class BitmapFactory implements ImageFactory {
    public ImageBuilder getImageBuilder() {
        return new BitmapImage.BitmapBuilder().prepare(new BitmapImage());
    }
}
