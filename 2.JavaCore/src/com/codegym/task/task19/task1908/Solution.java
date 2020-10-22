package com.codegym.task.task19.task1908;

/* 
Picking out numbers
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Matcher m = Pattern.compile("\\b\\d+\\b").matcher(sb.toString());
            while(m.find()) output.write(m.group() + " ");
        }
    }
}


