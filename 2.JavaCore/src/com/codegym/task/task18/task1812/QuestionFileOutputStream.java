package com.codegym.task.task18.task1812;

import java.io.*;

/* 
Extending AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private final AmigoOutputStream amigo;

    public QuestionFileOutputStream(AmigoOutputStream amigo) {
        this.amigo = amigo;
    }

    @Override
    public void flush() throws IOException {
        amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigo.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Do you really want to close the stream? Y/N");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        if (buff.readLine().toUpperCase().equals("Y")) amigo.close();
        buff.close();
    }
}

