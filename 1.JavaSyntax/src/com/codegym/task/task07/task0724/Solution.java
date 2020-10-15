package com.codegym.task.task07.task0724;

/* 
Family census
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Human gf1 = new Human("Buddy", true, 73);
        Human gf2 = new Human("Floyd", true, 82);
        Human gm1 = new Human("Joanette", false, 90);
        Human gm2 = new Human("Sadie", false, 68);
        Human f = new Human("James", true, 81, gf1, gm1);
        Human m = new Human("Judy", false, 79, gf2, gm2);
        Human c1 = new Human("Lori", false, 55, f, m);
        Human c2 = new Human("Sadie", true, 51, f, m);
        Human c3 = new Human("Sadie", true, 47, f, m);
        Human[] family = {gf1, gf2, gm1, gm2, f, m, c1, c2, c3};
        Arrays.stream(family).forEach(System.out::println);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "" + ("Name: " + this.name);
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;
            if (this.father != null) text += ", father: " + this.father.name;
            if (this.mother != null) text += ", mother: " + this.mother.name;
            return text;
        }
    }
}
