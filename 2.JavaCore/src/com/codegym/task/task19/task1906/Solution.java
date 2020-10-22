package com.codegym.task.task19.task1906;

/* 
Even characters
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1, file2;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = buff.readLine();
            file2 = buff.readLine();
        }

        try (FileReader input = new FileReader(file1);
             FileWriter output = new FileWriter(file2)) {
            int ordinal = 1;
            while (input.ready()) {
                int data = input.read();
                if (ordinal++ % 2 == 0) output.write(data);
            }
        }
    }
}

