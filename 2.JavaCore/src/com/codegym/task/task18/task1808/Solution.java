package com.codegym.task.task18.task1808;

/* 
Splitting a file
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File[] files = new File[3];
        byte[] buffer;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 3; ++i) files[i] = new File(buff.readLine());
        }

        try (FileInputStream input = new FileInputStream(files[0]);
             FileOutputStream output1 = new FileOutputStream(files[1]);
             FileOutputStream output2 = new FileOutputStream(files[2])) {
            int size = input.available(), first = size - size / 2, second = size - first;

            buffer = new byte[first];
            output1.write(buffer, 0, input.read(buffer));

            buffer = new byte[second];
            output2.write(buffer, 0, input.read(buffer));
        }
    }
}

