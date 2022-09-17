package com.codegym.task.task25.task2512;

/* 
Charting our own course
*/

import java.util.*;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> stackTrace = new ArrayList<>();
        while (e != null) {
            stackTrace.add(e);
            e = e.getCause();
        }
        Collections.reverse(stackTrace);
        stackTrace.forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        Thread.currentThread().setDefaultUncaughtExceptionHandler(s);
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
