package com.codegym.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
More Sam-I-Am
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("Sam");
        list.add("I");
        list.add("Am");
        for (int i = 1; i <= list.size(); i+= 2) list.add(i, "Ham");
        list.forEach(System.out::println);
    }
}
