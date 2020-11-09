package com.codegym.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Inverted words
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader read = new BufferedReader(new FileReader(buff.readLine()))) {
            while (read.ready()) words.addAll(Arrays.asList(read.readLine().split(" ")));
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); ++j) {
                if (i >= words.size()) break;
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                    Pair pair = new Pair();
                    pair.first = words.get(i);
                    pair.second = words.get(j);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j = -1;
                }
            }
        }

        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" : first == null ? second : second == null ?
                    first : first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
