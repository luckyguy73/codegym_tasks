package com.codegym.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
One large array and two small ones

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; ++i) nums[i] = Integer.parseInt(buff.readLine());
        int[] first = new int[10];
        int[] second = new int[10];
        first = Arrays.copyOfRange(nums, 0, nums.length / 2);
        second = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        Arrays.stream(second).forEach(System.out::println);
    }
}
