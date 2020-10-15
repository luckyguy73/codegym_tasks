package com.codegym.task.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
List of number arrays
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {1, 2};
        int[] three = {1, 2, 3, 4};
        int[] four = {1, 2, 3, 4, 5, 6, 7};
        int[] five = {};
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
