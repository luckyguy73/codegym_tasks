package com.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
File in a static block
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();

    static {
        File file = new File(Statics.FILE_NAME);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}



