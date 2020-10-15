package com.codegym.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Streets and houses
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[15];
        int sumEven = 0, sumOdd = 0;
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(buff.readLine());
            if (i % 2 == 0) sumEven += nums[i];
            else sumOdd += nums[i];
        }
        if (sumEven > sumOdd) System.out.println("Even-numbered houses have more residents.");
        else System.out.println("Odd-numbered houses have more residents.");
    }
}
