package com.codegym.task.task08.task0802;

import java.util.HashMap;

/* 
HashMap of 10 pairs
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();

        map.put("watermelon", "melon");
        map.put("banana", "fruit");
        map.put("cherry", "fruit");
        map.put("pear", "fruit");
        map.put("cantaloupe", "melon");
        map.put("blackberry", "fruit");
        map.put("ginseng", "root");
        map.put("strawberry", "fruit");
        map.put("iris", "flower");
        map.put("potato", "tuber");

        map.forEach((k, v) -> System.out.printf("%s - %s\n", k, v));
    }
}
