package com.codegym.task.task18.task1809;

/* 
Reversing a file
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile, outputFile;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = buff.readLine();
            outputFile = buff.readLine();
        }

        try (FileInputStream input = new FileInputStream(inputFile);
             FileOutputStream output = new FileOutputStream(outputFile)) {
            int[] bytes = new int[input.available()];
            for (int i = 0; i < bytes.length; ++i) bytes[i] = input.read();
            for (int i = bytes.length - 1; i >= 0; --i) output.write(bytes[i]);
        }
    }
}







