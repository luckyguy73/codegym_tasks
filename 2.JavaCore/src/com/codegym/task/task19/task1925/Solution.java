package com.codegym.task.task19.task1925;

/* 
Long words
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]));
             FileWriter output = new FileWriter(args[1])) {
            while (input.ready()) {
                String[] line = input.readLine().split("\\s+");
                String[] arr = Arrays.stream(line).filter(f -> f.length() > 6).toArray(String[]::new);
                lines.addAll(Arrays.asList(arr));
            }
            output.write(String.join(",", lines));
        }
    }
}


