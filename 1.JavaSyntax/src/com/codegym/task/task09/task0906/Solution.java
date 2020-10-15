package com.codegym.task.task09.task0906;

/* 
Logging stack traces
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.printf("%s: %s: %s\n", elements[2].getClassName(), elements[2].getMethodName(), s);
    }
}
