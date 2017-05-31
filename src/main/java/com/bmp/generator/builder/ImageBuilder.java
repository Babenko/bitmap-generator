package com.bmp.generator.builder;

import com.bmp.generator.entry.Image;

/**
 * @author Sem Babenko.
 */
public interface ImageBuilder {

    ImageBuilder withValue(int val);

    ImageBuilder withWidth(int width);

    ImageBuilder withHeight(int height);

    Image build();
}
