package com.codegym.task.task08.task0801;

import java.util.HashSet;

/* 
HashSet of plants
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> set = new HashSet<>();

        set.add("watermelon");
        set.add("banana");
        set.add("cherry");
        set.add("pear");
        set.add("cantaloupe");
        set.add("blackberry");
        set.add("ginseng");
        set.add("strawberry");
        set.add("iris");
        set.add("potato");

        set.forEach(System.out::println);
    }
}
