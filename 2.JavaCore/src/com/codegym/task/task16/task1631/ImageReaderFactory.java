package com.codegym.task.task16.task1631;

import com.codegym.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader reader;
        if (type == ImageTypes.BMP) reader = new BmpReader();
        else if (type == ImageTypes.JPG) reader = new JpgReader();
        else if (type == ImageTypes.PNG) reader = new PngReader();
        else throw new IllegalArgumentException("Not a valid type");
        return reader;
    }
}
