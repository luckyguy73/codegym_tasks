package com.codegym.task.task14.task1419;

import java.io.IOException;
import java.util.*;

/* 
Exception invasion
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // The first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) { exceptions.add(e); }

        String key = null;
        try {
            key.length();
        } catch (Exception e) { exceptions.add(e); }

        exceptions.add(new IllegalArgumentException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new IllegalStateException());
        exceptions.add(new ConcurrentModificationException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new IOException());
    }
}
