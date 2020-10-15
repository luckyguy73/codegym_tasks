package com.codegym.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Cat relations
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        Cat grandfather = new Cat(grandfatherName);

        String grandmotherName = reader.readLine();
        Cat grandmother = new Cat(grandmotherName);

        String fn = reader.readLine();
        Cat father = new Cat(fn, grandfather, null);

        String mn = reader.readLine();
        Cat mother = new Cat(mn, null, grandmother);

        String sn = reader.readLine();
        Cat son = new Cat(sn, father, mother);

        String dn = reader.readLine();
        Cat daughter = new Cat(dn, father, mother);


        System.out.println(grandfather);
        System.out.println(grandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private final String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.format("The cat's name is %s, ", name));
            if (mother == null) sb.append("no mother, ");
            else sb.append(mother.name).append(" is the mother, ");
            if (father == null) sb.append("no father");
            else sb.append(father.name).append(" is the father");
            return sb.toString();
        }
    }
}
