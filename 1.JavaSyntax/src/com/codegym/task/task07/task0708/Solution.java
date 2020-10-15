package com.codegym.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Longest string

*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 5; ++i) strings.add(buff.readLine());
        for (String string : strings) max = Math.max(max, string.length());
        for (String s : strings) if (s.length() == max) System.out.println(s);
    }
}
