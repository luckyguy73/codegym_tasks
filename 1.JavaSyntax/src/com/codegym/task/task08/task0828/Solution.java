package com.codegym.task.task08.task0828;

import java.util.*;

/* 
Month number
*/

public class Solution {

    public static void main(String[] args) {
        String[] month_names = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        Map<String, Integer> months = new HashMap<>();
        for (int i = 0; i < 12; ++i) months.put(month_names[i], i + 1);
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        System.out.printf("%s is month %d", month, months.get(month));
    }
}
