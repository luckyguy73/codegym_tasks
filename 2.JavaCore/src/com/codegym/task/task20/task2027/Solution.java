package com.codegym.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Word search
*/

public class Solution {
    public static void main(String[] args) {
        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(wordSearch, "home", "same"));

        /*
        Expected result
        home - (5, 3) - (2, 0)
        same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {
        List<Word> out = new ArrayList<>();
        int rows = wordSearch.length, cols = wordSearch[0].length;
        for (String s : words) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    Word word = new Word("");
                    if (wordSearch[i][j] == s.charAt(0)) word = checkCell(wordSearch, i, j, rows, cols, s);
                    if (!word.text.equals("")) out.add(word);
                }
            }
        }
        return out;
    }

    private static Word checkCell(int[][] matrix, int x, int y, int rows, int cols, String s) {
        int len = s.length();
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (i == 0 && j == 0) continue;
                int row = x + i, col = y + j, k;
                for (k = 1; k < len; ++k) {
                    if (!isValid(row, col, rows, cols) || matrix[row][col] != s.charAt(k)) break;
                    row += i;
                    col += j;
                }
                if (k == len) {
                    Word word = new Word(s);
                    word.setStartPoint(y, x);
                    word.setEndPoint(col - j, row - i);
                    return word;
                }
            }
        }
        return new Word("");
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >=0 && col < cols;
    }

    public static class Word {
        private final String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
