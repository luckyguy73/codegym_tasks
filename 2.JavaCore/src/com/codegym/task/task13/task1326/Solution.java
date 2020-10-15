package com.codegym.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Sorting even numbers from a file
*/

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String line;
        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(read.readLine())))) {
            while ((line = stream.readLine()) != null) list.add(Integer.parseInt(line));
        } catch (IOException e) { e.printStackTrace(); }
        Collections.sort(list);
        list.stream().filter(f -> f % 2 == 0).forEach(System.out::println);
    }
}
