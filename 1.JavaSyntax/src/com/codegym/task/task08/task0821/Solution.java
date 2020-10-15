package com.codegym.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Shared last names and first names
*/

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Morgan", "Ashton");
        map.put("Marshall", "Bella");
        map.put("Morgan", "Billy");
        map.put("Nguyen", "Bobby");
        map.put("Jones", "Mike");
        map.put("Smith", "Mike");
        map.put("Lee", "Clayton");
        map.put("Anderson", "Will");
        map.put("Pederson", "Joc");
        map.put("Kershaw", "Clayton");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
