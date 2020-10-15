package com.codegym.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ascending numbers
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) list.add(Integer.parseInt(reader.readLine()));
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
