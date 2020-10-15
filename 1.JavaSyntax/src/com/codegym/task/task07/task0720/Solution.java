package com.codegym.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Shuffled just in time
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; ++i) list.add(reader.readLine());

        for (int i = 0; i < M; ++i) {
            String s = list.remove(0);
            list.add(s);
        }

        list.forEach(System.out::println);
    }
}
