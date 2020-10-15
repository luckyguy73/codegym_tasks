package com.codegym.task.task15.task1507;

/* 
OOP: Method overloading
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Filling with String objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Integer value) {
        System.out.println("Filling with Integer objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Boolean value) {
        System.out.println("Filling with Boolean objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Character value) {
        System.out.println("Filling with Character objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Short value) {
        System.out.println("Filling with Short objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Byte value) {
        System.out.println("Filling with Byte objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Double value) {
        System.out.println("Filling with Double objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Float value) {
        System.out.println("Filling with Float objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Long value) {
        System.out.println("Filling with Long objects");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
