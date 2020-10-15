package com.codegym.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Static modifiers: part 2
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN;

    static {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try {
            A = Integer.parseInt(buff.readLine());
            B = Integer.parseInt(buff.readLine());
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MIN = min(A, B);
    }

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}
