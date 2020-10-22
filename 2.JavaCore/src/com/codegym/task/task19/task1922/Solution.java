package com.codegym.task.task19.task1922;

import java.io.*;
import java.util.*;

/* 
Searching for the right lines
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) throws IOException {
        String file;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = buff.readLine();
        }

        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            while (input.ready()) {
                String s = input.readLine();
                String[] arr = s.split("\\s+");
                long count = Arrays.stream(arr).filter(f -> words.contains(f)).count();
                if (count == 2) System.out.println(s);
            }
        }
    }
}


