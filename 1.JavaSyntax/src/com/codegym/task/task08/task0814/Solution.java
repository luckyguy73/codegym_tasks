package com.codegym.task.task08.task0814;

import java.util.*;

/* 
Greater than 10? You're not a good fit for us
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        Random r = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 20) set.add(r.nextInt(20));
        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        set.removeIf(i -> i > 10);
        return set;
    }

    public static void main(String[] args) {

    }
}
