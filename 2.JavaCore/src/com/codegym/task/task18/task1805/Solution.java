package com.codegym.task.task18.task1805;

import java.io.*;
import java.util.*;

/* 
Sorting bytes
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(buff.readLine());
        }

        Set<Integer> set = new TreeSet<>();

        try (FileInputStream stream = new FileInputStream(file)) {
            while (stream.available() > 0) set.add(stream.read());
        }

        set.forEach(f -> System.out.print(f + " "));
    }
}
