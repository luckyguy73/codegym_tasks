package com.codegym.task.task08.task0824;

/* 
Make a family
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Human m_gf = new Human("Floyd", true, 82);
        Human p_gf = new Human("John", true, 78);
        Human m_gm = new Human("Sadie", false, 67);
        Human p_gm = new Human("Joanette", false, 88);
        Human father = new Human("James", true, 81);
        Human mother = new Human("Judy", false, 79);
        Human lori = new Human("Lori", false, 55);
        Human tod = new Human("Tod", true, 51);
        Human eric = new Human("Eric", true, 45);
        m_gf.children.add(mother);
        p_gf.children.add(father);
        m_gm.children.add(mother);
        p_gm.children.add(father);
        mother.children.add(lori);
        mother.children.add(tod);
        mother.children.add(eric);
        father.children.add(lori);
        father.children.add(tod);
        father.children.add(eric);
        List<Human> humans = Arrays.asList(m_gf, m_gm, p_gf, p_gm, mother, father, lori, tod, eric);
        humans.forEach(System.out::println);
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Name: " + this.name;
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", children: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
