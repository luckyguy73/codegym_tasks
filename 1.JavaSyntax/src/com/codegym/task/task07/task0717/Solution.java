package com.codegym.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Duplicating words
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; ++i) strings.add(buff.readLine());
        ArrayList<String> result = doubleValues(strings);
        result.forEach(System.out::println);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = 1; i <= list.size(); i += 2) list.add(i, list.get(i - 1));
        return list;
    }
}
