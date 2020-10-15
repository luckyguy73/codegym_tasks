package com.codegym.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Shortest or longest
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; ++i) strings.add(buff.readLine());
        int min = strings.stream().mapToInt(String::length).min().orElse(0);
        int max = strings.stream().mapToInt(String::length).max().orElse(0);
        String shortest = strings.stream().filter(f -> f.length() == min).findFirst().orElse(null);
        String longest = strings.stream().filter(f -> f.length() == max).findFirst().orElse(null);
        System.out.println(strings.indexOf(shortest) < strings.indexOf(longest) ? shortest : longest);
    }
}
