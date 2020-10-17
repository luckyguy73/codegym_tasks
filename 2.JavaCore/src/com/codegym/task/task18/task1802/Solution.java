package com.codegym.task.task18.task1802;

import java.io.*;

/* 
Minimum byte
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        File file = null;
        int min = 255;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(buff.readLine());
        }

        try (FileInputStream stream = new FileInputStream(file)) {
            while (stream.available() > 0) {
                int data = stream.read();
                min = Math.min(min, data);
            }
        }

        System.out.println(min);
    }
}





