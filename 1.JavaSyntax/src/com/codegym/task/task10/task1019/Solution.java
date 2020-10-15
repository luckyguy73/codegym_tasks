package com.codegym.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Functionality is not enough!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int id;
        String name;

        while (true) {
            try { id = Integer.parseInt(read.readLine()); }
            catch (NumberFormatException e) { break; }
            name = read.readLine();
            map.put(name, id);
        }

        map.forEach((k, v) -> System.out.printf("%s %s\n", v, k));
    }
}
