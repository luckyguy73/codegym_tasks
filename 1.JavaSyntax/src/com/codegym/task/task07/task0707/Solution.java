package com.codegym.task.task07.task0707;

import java.util.*;

/* 
What sort of list is that?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("ash");
        list.add("bella");
        list.add("marc");
        list.add("lori");
        list.add("apollos");
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
