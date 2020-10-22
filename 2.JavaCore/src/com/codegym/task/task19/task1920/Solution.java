package com.codegym.task.task19.task1920;

/* 
The richest
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
        double max = map.values().stream().max(Double::compareTo).orElse(0.0);
        map.entrySet().stream().filter(f -> f.getValue() == max).forEach(e -> System.out.println(e.getKey()));
    }
}



