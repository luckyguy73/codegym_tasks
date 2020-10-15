package com.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Different methods for different types
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String data;
        while (!(data = buff.readLine()).equals("exit")) {
            try {
                int num;
                if (data.contains(".")) print(Double.parseDouble(data));
                else if ((num = Integer.parseInt(data)) > 0 && num < 128) print((short)num);
                else print(num);
            } catch (NumberFormatException e) {
                print(data);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }
}
