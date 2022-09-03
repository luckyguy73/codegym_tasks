package com.codegym.task.task22.task2209;

/* 
Make a word chain
*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader read = new BufferedReader(new FileReader(buff.readLine()))) {
            while (read.ready()) words.addAll(Arrays.asList(read.readLine().split("\\s+")));
        }

        System.out.println(getLine(words.toArray(new String[0])));
    }

    public static StringBuilder getLine(String... words) {
        Comparator<String> stringLength = Comparator.comparing(String::length).reversed();
        TreeSet<String> extract = iterations("", Arrays.asList(words), new TreeSet<>(stringLength));

        return new StringBuilder(extract.stream().findFirst().orElse(""));
    }

    public static TreeSet<String> iterations(String base, List<String> words, TreeSet<String> upshot) {
        for (String word : words) {
            if (!base.isEmpty() && !isEqual(base, word)) continue;
            String concat = base.isEmpty() ? word : String.format("%s %s", base, word);
            upshot.add(concat);
            if (words.size() > 1) iterations(concat, words.stream().filter(e -> !e.equals(word)).collect(Collectors.toList()), upshot);
        }

        return upshot;
    }

    public static boolean isEqual(String base, String word) {
        return base.toLowerCase().charAt(base.length() - 1) == word.toLowerCase().charAt(0);
    }

}
