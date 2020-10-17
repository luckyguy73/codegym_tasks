package com.codegym.task.task18.task1823;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Threads and bytes
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = buff.readLine()).toLowerCase().equals("exit")) new ReadThread(fileName).start();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run() {
            int[] bytes = new int[256];
            try (FileInputStream stream = new FileInputStream(getName())) {
                while (stream.available() > 0) bytes[stream.read()]++;
            } catch (IOException e) { e.printStackTrace(); }
            int max = Arrays.stream(bytes).max().getAsInt();
            for (int i = 0; i < bytes.length; ++i) if (bytes[i] == max) resultMap.put(getName(), i);
        }
    }
}



