package com.codegym.task.task22.task2202;

/* 
Find a substring
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new StringTooShortException();
        String[] strings = string.split(" ");
        if (strings.length < 5) throw new StringTooShortException();
        StringBuilder sb = new StringBuilder(strings[1]);
        for (int i = 2; i < 5; ++i) sb.append(" ").append(strings[i]);
        return sb.toString();
    }

    public static class StringTooShortException extends RuntimeException {
    }
}

