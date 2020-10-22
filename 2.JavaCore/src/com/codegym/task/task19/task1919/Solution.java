package com.codegym.task.task19.task1919;

/* 
Calculating salaries
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader buff = new BufferedReader(new FileReader(args[0]))) {
            while (buff.ready()) {
                String[] arr = buff.readLine().split("\\s+");
                map.merge(arr[0], Double.parseDouble(arr[1]), Double::sum);
            }
        }
        map.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
    }
}



