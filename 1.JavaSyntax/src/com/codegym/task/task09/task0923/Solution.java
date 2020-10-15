package com.codegym.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Vowels and consonants
*/

public class Solution {
    public static char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String text = read.readLine();
        for (char c : text.toCharArray()) if (isVowel(c)) System.out.print(c + " ");
        System.out.println();
        for (char c : text.toCharArray()) if (!isVowel(c) && c != ' ') System.out.print(c + " ");
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        for (char d : vowels) if (c == d) return true;
        return false;
    }
}
