package com.codegym.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            while (true)
                try (FileInputStream input = new FileInputStream(buff.readLine())) {
                    if (input.available() < 1000) throw new DownloadException();
                }
        }
    }

    public static class DownloadException extends Exception {

    }
}
