package com.codegym.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Expressing ourselves more concisely
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; ++i) strings.add(buff.readLine());
        int min = strings.stream().mapToInt(String::length).min().orElse(0);
        strings = (ArrayList<String>) strings.stream().filter(f -> f.length() == min).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }
}
