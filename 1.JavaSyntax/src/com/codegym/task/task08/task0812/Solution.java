package com.codegym.task.task08.task0812;

import java.io.*;
import java.util.*;

/* 
Longest sequence
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //write your code here
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int n = 10, c = 1, max = 1;
        for (int i = 0; i < n; ++i) list.add(Integer.parseInt(read.readLine()));
        for (int i = 1; i < n; ++i) {
            c++;
            if (!list.get(i).equals(list.get(i - 1))) c = 1;
            if (c > max) max = c;
        }
        System.out.println(max);
    }
}
