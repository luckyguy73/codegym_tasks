package com.codegym.task.task09.task0905;

/* 
In the blue depths of the stack trace…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.println(elements.length);
        return elements.length;
    }
}

