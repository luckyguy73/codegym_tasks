package com.codegym.task.task08.task0827;

import java.util.Date;

/* 
Working with dates
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String string) {
        Date date = new Date(string);

        Date startDate = new Date(2020, 0, 1);
        startDate.setYear(date.getYear());

        long msTimeDifference = date.getTime() - startDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;

        int dayCount = (int) (msTimeDifference / msDay);

        return dayCount % 2 == 0; // accounts for including first day of year as 1 instead of 0
    }
}
