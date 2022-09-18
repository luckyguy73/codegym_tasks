package com.codegym.task.task26.task2601;

/* 
Read online about the median of a sample
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) { }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int len = array.length, middle = len / 2;
        int median = len % 2 == 0 ? (array[middle] + array[middle - 1]) / 2 : array[middle];
        Comparator<Integer> integerComparator = Comparator.comparingInt(a -> Math.abs(a - median));
        Arrays.sort(array, integerComparator);
        return array;
    }

}
