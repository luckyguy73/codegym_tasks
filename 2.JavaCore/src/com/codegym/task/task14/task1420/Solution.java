package com.codegym.task.task14.task1420;

/* 
GCD
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a < 1 || b < 1) throw new IllegalStateException();
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
