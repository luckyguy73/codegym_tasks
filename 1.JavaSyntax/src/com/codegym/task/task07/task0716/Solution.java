package com.codegym.task.task07.task0716;

import java.util.ArrayList;
import java.util.List;

/* 
R or L
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("rose"); // 0
        list.add("love"); // 1
        list.add("lyre"); // 2
        list = fix(list);

        for (String s : list) System.out.println(s);
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> results = new ArrayList<>();
        for (String s : list) {
            if (s.contains("r") && s.contains("l")) results.add(s);
            else if (s.contains("l")) {
                results.add(s);
                results.add(s);
            } else if (!s.contains("r")) results.add(s);
        }
        return results;
    }
}
