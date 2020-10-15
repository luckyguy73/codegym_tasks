package com.codegym.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
String array in reverse order
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[10];
        for (int i = 0; i < 8; ++i) strings[i] = buff.readLine();
        List<String> list = Arrays.asList(strings);
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}
