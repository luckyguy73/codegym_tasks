package com.codegym.task.task09.task0921;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Method in a try-catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        List<Integer> list = new ArrayList<>();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String text = read.readLine();
                int num = Integer.parseInt(text);
                list.add(num);
            }
        } catch (NumberFormatException | IOException e) {
            list.forEach(System.out::println);
        }
    }
}
