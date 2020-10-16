package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();
    public static SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws ParseException {
        String a = args[0];
        if (a.equals("-c")) {
            Date bd = formatter.parse(args[3]);
            if (args[2].equals("m")) allPeople.add(Person.createMale(args[1], bd));
            else allPeople.add(Person.createFemale(args[1], bd));
            System.out.println(allPeople.size() - 1);
        } else if (a.equals("-u")) {
            int index = Integer.parseInt(args[1]);
            Date bd = formatter.parse(args[4]);
            Person person = allPeople.get(index);
            if (person == null) throw new IllegalArgumentException();
            person.setName(args[2]);
            person.setSex(args[3].equals("m") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(bd);
        } else if (a.equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
        else System.out.println(allPeople.get(Integer.parseInt(args[1])));
    }
}


