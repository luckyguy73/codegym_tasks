package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    private static final SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat birthdate = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            boolean isMale = args[i + 1].equals("m");
                            String name = args[i];
                            Date bd = formatter.parse(args[i + 2]);
                            allPeople.add(isMale ? Person.createMale(name, bd) : Person.createFemale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            boolean isMale = args[i + 2].equals("m");
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            Date bd = formatter.parse(args[i + 3]);
                            Person person = allPeople.get(id);
                            person.setName(name);
                            person.setBirthDate(bd);
                            person.setSex(isMale ? Sex.MALE : Sex.FEMALE);
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; ++i) {
                            int id = Integer.parseInt(args[i]);
                            Person person = allPeople.get(id);
                            person.setName(null);
                            person.setBirthDate(null);
                            person.setSex(null);
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; ++i) {
                            int id = Integer.parseInt(args[i]);
                            Person p = allPeople.get(id);
                            String bd = birthdate.format(p.getBirthDate());
                            String sex = p.getSex().equals(Sex.MALE) ? "m" : "f";
                            System.out.printf("%s %s %s%n", p.getName(), sex, bd);
                        }
                    }
                    break;
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }
}





















