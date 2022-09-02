package com.codegym.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Caesar cipher
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        int ch;
        StringBuilder sb = new StringBuilder();
        while (reader != null && (ch = reader.read()) != -1) sb.append((char) (ch + key));
        return sb.toString();
    }
}
