package com.codegym.task.task22.task2212;

/* 
Phone number verification
*/

public class Solution {
    public static boolean checkPhoneNumber(String telNumber) {
        if (telNumber == null) return false;
        return  (telNumber.matches("^\\+(\\d[\\-()]?){11}\\d$") || telNumber.matches("^[(\\d]-?(\\d[\\-)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }

    public static void main(String[] args) {

    }
}
