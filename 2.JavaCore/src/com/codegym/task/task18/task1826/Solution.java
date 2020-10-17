package com.codegym.task.task18.task1826;

/* 
Encryption
*/

import java.io.*;

public class Solution {
    private static final int KEY = 12;

    public static void main(String[] args) throws IOException {
        try (FileInputStream input = new FileInputStream(args[1]);
             FileOutputStream output = new FileOutputStream(args[2])) {
            while (input.available() > 0) {
                int data = input.read();
                if (args[0].equals("-e")) data += KEY;
                else data -= KEY;
                output.write(data);
            }
        }
    }
}



