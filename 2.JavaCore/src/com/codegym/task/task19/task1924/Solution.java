package com.codegym.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) throws IOException {
        String file;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = buff.readLine();
        }
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            while (input.ready()) {
                String[] arr = input.readLine().split("\\s+");
                for (int i = 0; i < arr.length; ++i)
                    try {
                        int num = Integer.parseInt(arr[i]);
                        if (map.containsKey(num)) arr[i] = map.get(num);
                    } catch (NumberFormatException ignore) { }
                System.out.println(String.join(" ", arr));
            }
        }
    }
}



