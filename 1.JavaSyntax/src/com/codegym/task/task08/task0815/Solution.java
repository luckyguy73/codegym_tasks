package com.codegym.task.task08.task0815;

import java.util.*;

/* 
Census

*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //write your code here
        HashMap<String, String> map = new HashMap<>();
        map.put("Morgan", "Ashton");
        map.put("Marshall", "Bella");
        map.put("Vu", "Billy");
        map.put("Nguyen", "Bobby");
        map.put("Jones", "Mike");
        map.put("Smith", "Mike");
        map.put("Lee", "Clayton");
        map.put("Anderson", "Will");
        map.put("Pederson", "Joc");
        map.put("Kershaw", "Clayton");
        return map;
    }

    public static int getSameFirstNameCount(HashMap<String, String> map, String name) {
        //write your code here
        int count = 0;
        for (String s : map.values()) if (s.equals(name)) count++;
        return count;
    }

    public static int getSameLastNameCount(HashMap<String, String> map, String lastName) {
        //write your code here
        int count = 0;
        for (String s : map.keySet()) if (s.equals(lastName)) count++;
        return count;
    }

    public static void main(String[] args) {

    }
}
