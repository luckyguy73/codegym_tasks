package com.codegym.task.task32.task3201;

/* 
Writing to an existing file
*/

import java.io.*;

public class Solution {
    public static void main(String... args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]), length = raf.length();
            number = Math.min(number, length);
            raf.seek(number);
            raf.write(args[2].getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
