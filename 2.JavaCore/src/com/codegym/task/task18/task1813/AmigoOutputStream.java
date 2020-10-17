package com.codegym.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream output;

    public AmigoOutputStream(FileOutputStream output) throws FileNotFoundException {
        super(fileName);
        this.output = output;
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        output.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        output.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        this.flush();
        this.write("CodeGym © All rights reserved.".getBytes());
        output.close();
    }

    @Override
    public void flush() throws IOException {
        output.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}
