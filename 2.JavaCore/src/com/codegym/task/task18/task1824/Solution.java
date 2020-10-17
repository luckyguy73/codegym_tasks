package com.codegym.task.task18.task1824;

/* 
Files and exceptions
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String file;
        while ((file = buff.readLine()) != null) {
            try (FileInputStream stream = new FileInputStream(file)) {

            } catch (FileNotFoundException e) {
                System.out.println(file);
                break;
            }
        }
    }
}





