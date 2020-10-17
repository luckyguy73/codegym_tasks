package com.codegym.task.task18.task1807;

/* 
Counting commas
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(buff.readLine());

        int count = 0;

        while (input.available() > 0) if (input.read() == 44) count++;

        System.out.println(count);

        buff.close();
        input.close();
    }
}

