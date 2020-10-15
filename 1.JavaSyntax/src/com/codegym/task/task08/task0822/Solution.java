package com.codegym.task.task08.task0822;

import java.util.*;

/* 
Minimum of N numbers
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        return Collections.min(array);
    }

    public static List<Integer> getIntegerList() {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) list.add(scan.nextInt());
        return list;
    }
}
