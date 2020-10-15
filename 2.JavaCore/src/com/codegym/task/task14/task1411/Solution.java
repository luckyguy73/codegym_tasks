package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
User, loser, coder and programmer
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;
        Set<String> set = new HashSet<>(Arrays.asList("user", "loser", "coder", "programmer"));
        while (set.contains(key = reader.readLine())) {
            switch (key) {
                case "user": person = new Person.User(); break;
                case "loser": person = new Person.Loser(); break;
                case "coder": person = new Person.Coder(); break;
                case "programmer": person = new Person.Programmer(); break;
                default: break;
            }
            doWork(person);
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) ((Person.User) person).live();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof  Person.Coder) ((Person.Coder) person).writeCode();
        else ((Person.Programmer) person).enjoy();
    }
}



