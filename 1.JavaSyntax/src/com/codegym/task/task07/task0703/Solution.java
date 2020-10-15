package com.codegym.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Lonely arrays interact
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strings = new String[10];
        int[] nums = new int[10];
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; ++i) {
            strings[i] = buff.readLine();
            nums[i] = strings[i].length();
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
