package com.codegym.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
In decreasing order
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        List<Integer> n = IntStream.of(array).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < n.size(); ++i) array[i] = n.get(i);
    }
}
