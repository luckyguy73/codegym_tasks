package com.codegym.task.task22.task2210;

/* 
StringTokenizer
*/

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] tokens = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) tokens[i++] = tokenizer.nextToken();
        return tokens;
    }
}
