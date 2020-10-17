package com.codegym.task.task18.task1820;

/* 
Rounding numbers
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String file1 = buff.readLine();
        String file2 = buff.readLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             PrintWriter writer = new PrintWriter(new FileWriter(file2))) {
            while (reader.ready()) {
                String[] strings = reader.readLine().split("\\s+");
                Arrays.stream(strings).mapToDouble(Double::parseDouble).mapToLong(Math::round).forEach(f -> writer.print(f + " "));
            }
        }
    }
}


