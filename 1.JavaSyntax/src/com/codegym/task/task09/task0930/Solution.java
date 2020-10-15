package com.codegym.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Task about algorithms
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        List<String> strings = new ArrayList<>();
        List<String> nums = new ArrayList<>();

        for (String s : array) {
            if (isNumber(s)) nums.add(s);
            else strings.add(s);
        }

        strings.sort((a, b) -> {
            int result = -1;
            if (isGreaterThan(a, b)) result = 1;
            if (a.equals(b)) result = 0;
            return result;
        });

        nums.sort((a, b) -> {
            int i = Integer.parseInt(a);
            int j = Integer.parseInt(b);
            return Integer.compare(j, i);
        });

        for (int i = 0, s = 0, n = 0; i < array.length; ++i) {
            if (isNumber(array[i])) array[i] = nums.get(n++);
            else array[i] = strings.get(s++);
        }
    }

    // String comparison method: 'a' is greater than 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Is the passed string a number?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // The string contains a hyphen
                    || (!Character.isDigit(c) && c != '-') // or is not a number and doesn't start with a hyphen
                    || (i == 0 && c == '-' && chars.length == 1)) // or is a single hyphen
            {
                return false;
            }
        }
        return true;
    }
}
