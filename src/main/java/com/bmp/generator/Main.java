package com.bmp.generator;

import com.bmp.generator.entry.impl.bitmap.BitmapFactory;
import com.bmp.generator.factory.ImageFactory;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Sem Babenko.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        ImageFactory imageFactory = new BitmapFactory();

        byte[] source = imageFactory.getImageBuilder().withWidth(2).withHeight(2).withValue(1).build().getSource();

        try(FileOutputStream fileOutputStream = new FileOutputStream("./pixel.bmp")){
            fileOutputStream.write(source);
        }

    }

}
