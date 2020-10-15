package com.codegym.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
What's today's date?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String text = read.readLine();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy");
        System.out.println(output.format(date).toUpperCase());
    }
}
