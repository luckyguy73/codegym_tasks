package com.codegym.task.task19.task1909;

/* 
Changing punctuation marks
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1, file2;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = buff.readLine();
            file2 = buff.readLine();
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(file1));
             BufferedWriter output = new BufferedWriter(new FileWriter(file2))) {
            while (input.ready()) sb.append((char) input.read());
            String outputString = sb.toString().replaceAll("\\.", "!");
            output.write(outputString);
        }
    }
}


