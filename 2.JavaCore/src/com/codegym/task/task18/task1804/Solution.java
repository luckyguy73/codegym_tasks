package com.codegym.task.task18.task1804;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 
Rarest bytes
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(buff.readLine());
        }

        int[] byteCount = new int[255];

        try (FileInputStream stream = new FileInputStream(file)) {
            while (stream.available() > 0) byteCount[stream.read()]++;
        }

        int min = Arrays.stream(byteCount).filter(f -> f > 0).min().orElse(0);
        IntStream.range(0, byteCount.length).filter(i -> byteCount[i] == min).forEach(f -> System.out.print(f + " "));
    }
}
