package com.codegym.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set of cats
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //write your code here. step 3
        cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> set = new HashSet<>();
        Cat oliver = new Cat();
        Cat oreo = new Cat();
        Cat bear = new Cat();
        set.add(oliver);
        set.add(oreo);
        set.add(bear);
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4
        cats.forEach(System.out::println);
    }

    // step 1
    public static class Cat {

    }
}
