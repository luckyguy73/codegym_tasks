package com.codegym.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Display numbers in reverse order
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) list.add(Integer.parseInt(reader.readLine()));
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}
