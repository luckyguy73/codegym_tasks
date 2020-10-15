package com.codegym.task.task13.task1318;

import java.io.*;

/* 
Reading a file
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try (Reader input = new InputStreamReader(new FileInputStream(buff.readLine()))) {
            int data;
            while ((data = input.read()) != -1) System.out.print((char)data);
        } catch (IOException e) { e.printStackTrace(); }
        buff.close();
    }
}
