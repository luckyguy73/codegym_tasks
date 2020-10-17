package com.codegym.task.task18.task1816;

/* 
ABCs
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (FileInputStream input = new FileInputStream(args[0])) {
            while (input.available() > 0) if (Character.isLetter(input.read())) count++;
        }
        System.out.println(count);
    }
}


