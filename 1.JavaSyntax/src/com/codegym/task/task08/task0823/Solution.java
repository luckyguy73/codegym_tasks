package com.codegym.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Going national

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //write your code here
        System.out.println(Stream.of(s.trim().split("\\s+")).map(m -> m.substring(0, 1).toUpperCase() + m.substring(1)
                .toLowerCase()).collect(Collectors.joining(" ")));
    }
}
