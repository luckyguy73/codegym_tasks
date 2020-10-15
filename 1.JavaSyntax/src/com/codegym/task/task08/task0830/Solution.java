package com.codegym.task.task08.task0830;

import java.util.*;

/* 
Task about algorithms
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = new String[20];
        for (int i = 0; i < array.length; ++i) array[i] = scan.nextLine();
        sort(array);
        for (String x : array) System.out.println(x);
    }

    public static void sort(String[] array) {
        int n = array.length - 1;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n - i; ++j)
                if (isGreaterThan(array[j], array[j + 1])) {
                    String t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
    }

    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
