package com.codegym.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Min and max in arrays
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[20];
        for (int i = 0; i < 20; ++i) nums[i] = Integer.parseInt(reader.readLine());
        int minimum = Arrays.stream(nums).min().orElse(0);
        int maximum = Arrays.stream(nums).max().orElse(0);
        System.out.print(maximum + " " + minimum);
    }
}
