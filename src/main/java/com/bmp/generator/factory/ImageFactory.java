package com.bmp.generator.factory;

import com.bmp.generator.builder.ImageBuilder;

/**
 * @author Sem Babenko.
 */
public interface ImageFactory {

    ImageBuilder getImageBuilder();
}
