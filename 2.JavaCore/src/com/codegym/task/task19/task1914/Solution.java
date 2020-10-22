package com.codegym.task.task19.task1914;

/* 
Problem solving
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        String result = outputStream.toString();
        String[] arr = result.split("\\s+");
        int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[2]), answer = 0;
        if (arr[1].equals("+")) answer = a + b;
        else if (arr[1].equals("-")) answer = a - b;
        else answer = a * b;
        System.setOut(consoleStream);
        System.out.println(result + answer);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


