package com.codegym.task.task08.task0829;

import java.util.*;

/* 
Software update
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (true) {
            String city = scan.nextLine();
            if (city.isEmpty()) break;
            String family = scan.nextLine();
            map.put(city, family);
        }

        String request = scan.nextLine();
        System.out.println(map.get(request));
    }
}
