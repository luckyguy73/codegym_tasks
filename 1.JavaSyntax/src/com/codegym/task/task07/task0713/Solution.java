package com.codegym.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Playing Javarella

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> divBy3 = new ArrayList<>();
        ArrayList<Integer> divBy2 = new ArrayList<>();
        ArrayList<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < 20; ++i) nums.add(Integer.parseInt(reader.readLine()));
        for (int num : nums) {
            if (num % 3 == 0) divBy3.add(num);
            if (num % 2 == 0) divBy2.add(num);
            if (num % 3 != 0 && num % 2 != 0) remaining.add(num);
        }
        printList(divBy3);
        printList(divBy2);
        printList(remaining);
    }

    public static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
