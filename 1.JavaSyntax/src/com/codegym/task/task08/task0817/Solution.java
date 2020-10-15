package com.codegym.task.task08.task0817;

import java.util.*;

/* 
We don't need repeats

*/

@SuppressWarnings("DuplicatedCode")
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

    public static void removeFirstNameDuplicates(Map<String, String> map) {
        Set<String> names = new HashSet<>(), duplicates = new HashSet<>();
        for (String name : map.values()) {
            if (names.contains(name)) duplicates.add(name);
            names.add(name);
        }
        for (String name : duplicates) removeItemFromMapByValue(map, name);
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
            if (pair.getValue().equals(value)) map.remove(pair.getKey());
    }

    public static void main(String[] args) {

    }
}
