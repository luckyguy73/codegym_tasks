package com.codegym.task.task13.task1319;

import java.io.*;

/* 
Writing to a file from the console
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter file = new BufferedWriter(new FileWriter(buff.readLine()))) {
            String content;
            do {
                content = buff.readLine();
                file.write(content);
                file.newLine();
            } while (!content.equals("exit"));
        } catch (IOException e) { e.printStackTrace(); }
        buff.close();
    }
}
