package com.codegym.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Number of letters
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Alphabet
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();

        HashMap<Character, Integer> alphabet = new HashMap<>();
        for (char letter : abcArray) alphabet.put(letter, 0);

        // Read in strings
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (String s : list)
            for (char c : s.toCharArray())
                if (alphabet.containsKey(c))
                    alphabet.put(c, alphabet.get(c) + 1);

        alphabet.forEach((k, v) -> System.out.printf("%s %d\n", k, v));
    }

}
