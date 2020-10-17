package com.codegym.task.task18.task1819;

/* 
Combining files
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String file1 = buff.readLine();
        String file2 = buff.readLine();

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try (FileInputStream firstInput = new FileInputStream(file1);
             FileInputStream secondInput = new FileInputStream(file2)) {
            while (secondInput.available() > 0) bytes.write(secondInput.read());
            while (firstInput.available() > 0) bytes.write(firstInput.read());
        }

        try (FileOutputStream output = new FileOutputStream(file1)) {
            bytes.writeTo(output);
        }
    }
}


