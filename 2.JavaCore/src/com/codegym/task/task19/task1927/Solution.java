package com.codegym.task.task19.task1927;

/* 
Contextual advertising
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String ad = "CodeGym - online Java courses";
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        testString.printSomething();
        System.setOut(console);
        String[] arr = bytes.toString().split("\n");
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
            if (i % 2 != 0) System.out.println(ad);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}


