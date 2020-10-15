package com.codegym.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Flip the array

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[10];
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; ++i) nums[i] = Integer.parseInt(buff.readLine());
        for (int i = nums.length - 1; i >= 0; --i) System.out.println(nums[i]);
    }
}
