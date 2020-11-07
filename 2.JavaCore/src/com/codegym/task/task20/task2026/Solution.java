package com.codegym.task.task20.task2026;

/* 
Rectangle algorithms
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
    }

    public static int getRectangleCount(byte[][] arr) {
        int n = arr.length, count = 0;
        for (int row = 0; row < n; ++row)
            for (int col = 0; col < n; ++col)
                if (arr[row][col] == 1) {
                    getRectangleCount(arr, row, col, n);
                    count++;
                }
        return count;
    }

    private static void getRectangleCount(byte[][] arr, int x, int y, int n) {
        int[] D = {0, 1, 0, -1, 0};
        arr[x][y] = 2;
        for (int i = 0; i < D.length - 1; ++i) {
            int row = x + D[i], col = y + D[i + 1];
            if (row >= 0 && row < n && col >= 0 && col < n && arr[row][col] == 1)
                getRectangleCount(arr, row, col, n);
        }
    }
}
