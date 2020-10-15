package com.codegym.task.task06.task0614;

import java.util.ArrayList;

/* 
Static cats
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) cats.add(new Cat());

        printCats();
    }

    public static void printCats() {
        cats.forEach(System.out::println);
    }
}
