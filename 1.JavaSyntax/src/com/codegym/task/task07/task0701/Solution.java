package com.codegym.task.task07.task0701;

import java.util.*;

/* 
Maximum in an array
*/

public class Solution {
    public static void main(String[] args) {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[20];
        for (int i = 0; i < 20; ++i) nums[i] = scan.nextInt();
        return nums;
    }

    public static int max(int[] array) {
        return Arrays.stream(array).max().orElse(0);
    }
}
