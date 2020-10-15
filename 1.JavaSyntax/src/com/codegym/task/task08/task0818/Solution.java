package com.codegym.task.task08.task0818;

import java.util.*;

/* 
Only for the rich
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //write your code here
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Morgan", 1000);
        map.put("Marshall", 250);
        map.put("Vu", 700);
        map.put("Nguyen", 670);
        map.put("Jones", 300);
        map.put("Smith", 350);
        map.put("Lee", 220);
        map.put("Anderson", 650);
        map.put("Pederson", 550);
        map.put("Kershaw", 600);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        map.entrySet().removeIf(entry -> entry.getValue() < 500);
    }

    public static void main(String[] args) {

    }
}