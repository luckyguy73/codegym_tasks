package com.codegym.task.task18.task1801;

import java.io.*;

/* 
Maximum byte
*/

public class Solution {
    public static void main(String[] args) {
        File file = null;
        int max = 0;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(buff.readLine());
        } catch (IOException e) { e.printStackTrace(); }

        try (FileInputStream stream = new FileInputStream(file)) {
            while (stream.available() > 0) {
                int data = stream.read();
                max = Math.max(max, data);
            }
        } catch (IOException e) { e.printStackTrace(); }

        System.out.println(max);
    }
}



