package com.codegym.task.task20.task2025;

import java.util.*;

/*
Number algorithms
*/

public class Solution {

    public static long[] getNumbers(long n) {
        long[] powers = {0l,1l,2l,3l,4l,5l,6l,7l,8l,9l};
        List<Long> list = new ArrayList<>();
        long len = 10l;

        for (long i = 1l; i < n; ++i) {
            if (len == i) {
                len *= 10;
                for (int j = 0; j < powers.length; ++j) powers[j] *= j;
            }

            long x = i, sum = 0;
            while (x > 0) {
                int r = (int)(x % 10);
                sum += powers[r];
                x /= 10;
            }
            if (sum == i) list.add(sum);
        }
        return list.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(10000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
