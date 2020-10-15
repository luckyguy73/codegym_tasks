package com.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Request parser
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(buff.readLine());
        List<String[]> list = Arrays.stream(url.getQuery().split("&")).map(kv -> kv.split("=")).collect(Collectors.toList());
        String keys = list.stream().map(m -> m[0]).collect(Collectors.joining(" "));
        String s = list.stream().filter(f -> f[0].equals("obj")).map(m -> m[1]).collect(Collectors.joining());
        System.out.println(keys);
        if (!s.equals("")) {
            try {
                alert(Double.parseDouble(s));
            } catch (NumberFormatException e) { alert(s); }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
