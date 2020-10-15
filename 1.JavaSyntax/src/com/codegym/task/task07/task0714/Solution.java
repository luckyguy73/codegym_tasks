package com.codegym.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Words in reverse
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) list.add(buff.readLine());
        list.remove(2);
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}

