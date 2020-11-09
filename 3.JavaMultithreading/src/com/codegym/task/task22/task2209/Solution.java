package com.codegym.task.task22.task2209;

/* 
Make a word chain
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader read = new BufferedReader(new FileReader(buff.readLine()))) {
            while (read.ready()) words.addAll(Arrays.asList(read.readLine().split("\\s+")));
        }
        StringBuilder result = getLine(words.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length < 1) return sb;

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Set<Character> set = new HashSet<>();
        wordList.forEach(f -> set.add(f.toLowerCase().charAt(f.length() - 1)));

        for (String word : wordList) {
            if (!set.contains(word.toLowerCase().charAt(0))) {
                sb.append(word);
                wordList.remove(word);
                break;
            }
        }

        if (sb.length() < 1) {
            sb.append(wordList.get(0));
            wordList.remove(0);
        }

        for (int i = 0; i < wordList.size(); ++i) {
            String s = wordList.get(i);
            if (s.toLowerCase().charAt(0) == sb.charAt(sb.length() - 1)) {
                sb.append(" ").append(s);
                wordList.remove(s);
                i = -1;
            }
        }

        return sb;
    }
}
