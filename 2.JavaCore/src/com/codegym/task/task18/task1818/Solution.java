package com.codegym.task.task18.task1818;

/* 
Two in one
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File[] files = new File[3];

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 3; ++i) files[i] = new File(buff.readLine());
        }

        try (FileInputStream input1 = new FileInputStream(files[1]);
             FileInputStream input2 = new FileInputStream(files[2]);
             FileOutputStream output = new FileOutputStream(files[0], true)) {
            byte[] bytes = new byte[input1.available()];
            output.write(bytes, 0, input1.read(bytes));
            bytes = new byte[input2.available()];
            output.write(bytes, 0, input2.read(bytes));
        }
    }
}


