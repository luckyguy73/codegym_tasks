package com.codegym.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
John Johnson
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
        try (BufferedReader buff = new BufferedReader(new FileReader(args[0]))) {
            while (buff.ready()) {
                String[] arr = buff.readLine().split("\\s+");
                String name = String.join(" ", Arrays.copyOfRange(arr, 0, arr.length - 3));
                String mon = String.format("%02d", Integer.parseInt(arr[arr.length - 3]));
                String day = String.format("%02d", Integer.parseInt(arr[arr.length - 2]));
                String year = String.format("%4d", Integer.parseInt(arr[arr.length - 1]));
                Date bd = formatter.parse(mon + day + year);
                PEOPLE.add(new Person(name, bd));
            }
        }
    }
}


