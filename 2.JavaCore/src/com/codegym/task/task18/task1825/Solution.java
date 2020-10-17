package com.codegym.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Building a file
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Set<String> files = new TreeSet<>((a, b) -> {
            String[] one = a.split(".part"), two = b.split(".part");
            int num1 = Integer.parseInt(one[one.length - 1]);
            int num2 = Integer.parseInt(two[two.length - 1]);
            return num1 - num2;
        });
        String filename, output = null;
        while (!(filename = buff.readLine()).equals("end")) {
            files.add(filename);
            if (output == null) {
                int index = filename.lastIndexOf(".part");
                output = filename.substring(0, index);
            }
        }
        try (FileOutputStream stream = new FileOutputStream(output)) {
            for (String file : files)
                try (FileInputStream input = new FileInputStream(file)) {
                    byte[] buffer = new byte[input.available()];
                    stream.write(buffer, 0, input.read(buffer));
                }
        }
        buff.close();
    }
}


