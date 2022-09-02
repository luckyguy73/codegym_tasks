package com.codegym.task.task32.task3210;

import java.io.*;

/* 
Using RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String file = args[0], index = args[1], text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            int num = Integer.parseInt(index), textLength = text.length();
            byte[] bytes = new byte[textLength];
            raf.seek(num);
            raf.read(bytes, 0, textLength);
            raf.seek(raf.length());
            String readText = new String(bytes), out;
            if (readText.equals(text)) out = "true";
            else out = "false";
            raf.write(out.getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
