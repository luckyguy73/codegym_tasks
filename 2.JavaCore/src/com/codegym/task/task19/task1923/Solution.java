package com.codegym.task.task19.task1923;

import java.io.*;

/*
Words with numbers
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader buff = new BufferedReader(new FileReader(args[0]));
             FileWriter output = new FileWriter(args[1])) {
            while (buff.ready()) {
                String line = buff.readLine();
                String[] arr = line.split("\\s+");
                for (String word : arr) if (word.matches(".+\\d.+")) output.write(word + " ");
            }
        }
    }
}


