package com.codegym.task.task19.task1907;

/* 
Counting words
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = buff.readLine();
        }

        StringBuilder sb = new StringBuilder();
        try (FileReader read = new FileReader(file)) {
            while (read.ready()) sb.append((char)read.read());
        }

        String outputString = sb.toString().replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");

        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(outputString);

        int count = 0, i = 0;
        while (matcher.find(i)) {
            count++;
            i = matcher.start() + 1;
        }

        System.out.println(count);
    }
}




