package com.codegym.task.task09.task0927;

import java.util.*;

/* 
Ten cats
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
        map.put("oreo", new Cat("oreo"));
        map.put("oliver", new Cat("oliver"));
        map.put("ash", new Cat("ash"));
        map.put("boogie", new Cat("boogie"));
        map.put("bear", new Cat("bear"));
        map.put("biscuit", new Cat("biscuit"));
        map.put("great one", new Cat("great one"));
        map.put("midnight", new Cat("midnight"));
        map.put("felix", new Cat("felix"));
        map.put("tom", new Cat("tom"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
