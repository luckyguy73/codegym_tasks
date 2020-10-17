package com.codegym.task.task18.task1821;

/* 
Symbol frequency
*/

import java.io.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] bytes = new int[255];
        try (FileInputStream input = new FileInputStream(args[0])) {
            while (input.available() > 0) bytes[input.read()]++;
            IntStream.range(0, 255).filter(i -> bytes[i] > 0).forEach(i -> System.out.println((char)i + " " + bytes[i]));
        }
    }
}


