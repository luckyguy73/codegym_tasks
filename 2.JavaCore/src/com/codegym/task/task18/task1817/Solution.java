package com.codegym.task.task18.task1817;

/* 
Spaces
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        double spaces = 0, chars = 0;
        try (FileInputStream input = new FileInputStream(args[0])) {
            while (input.available() > 0 && ++chars > 0) if (Character.isSpaceChar(input.read())) spaces++;
        }
        System.out.printf("%.2f", spaces / chars * 100);
    }
}



