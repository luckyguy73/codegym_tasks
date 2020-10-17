package com.codegym.task.task18.task1822;

/* 
Finding data inside a file
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file = read.readLine(), id = args[0], line;

        try (BufferedReader stream = new BufferedReader(new FileReader(file))) {
            while (!(line = stream.readLine()).startsWith(id + " ")) { }
        }

        System.out.println(line);
    }
}

