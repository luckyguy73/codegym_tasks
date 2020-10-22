package com.codegym.task.task19.task1926;

/* 
Mirror image
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader input = new BufferedReader(new FileReader(buff.readLine()))) {
            while (input.ready()) System.out.println(new StringBuilder(input.readLine()).reverse());
        }
    }
}





