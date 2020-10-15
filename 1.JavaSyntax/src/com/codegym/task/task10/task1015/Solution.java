package com.codegym.task.task10.task1015;

import java.util.*;

/* 
Array of string lists
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] lists = new ArrayList[5];
        ArrayList<String> one = new ArrayList<>(Arrays.asList("ash", "is", "cash"));
        ArrayList<String> two = new ArrayList<>(Arrays.asList("bella", "morgan"));
        ArrayList<String> three = new ArrayList<>(Arrays.asList("marc", "lori"));
        ArrayList<String> four = new ArrayList<>(Arrays.asList("jim", "judy"));
        ArrayList<String> five = new ArrayList<>(Arrays.asList("vu", "family"));
        lists[0] = one;
        lists[1] = two;
        lists[2] = three;
        lists[3] = four;
        lists[4] = five;
        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}