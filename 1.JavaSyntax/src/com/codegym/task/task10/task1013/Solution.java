package com.codegym.task.task10.task1013;

/* 
Human class constructors
*/

public class Solution {
    public static void main(String[] args) {
    }

    @SuppressWarnings("FieldCanBeLocal")
    public static class Human {
        private boolean gender;
        private boolean student;
        private boolean working;
        private int age;
        private String name;
        private String occupation;

        public Human(String name) {
            this.name = name;
        }

        public Human(boolean student, boolean working) {
            this.student = student;
            this.working = working;
        }

        public Human(String name, String occupation) {
            this.name = name;
            this.occupation = occupation;
        }

        public Human(String name, boolean gender) {
            this.name = name;
            this.gender = gender;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, boolean gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public Human(String name, int age, boolean working, String occupation) {
            this.name = name;
            this.age = age;
            this.working = working;
            this.occupation = occupation;
        }

        public Human(String name, boolean gender, int age, boolean student) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.student = student;
        }

        public Human(String name, boolean gender, int age, boolean working, String occupation) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.working = working;
            this.occupation = occupation;
        }

        public Human(String name, boolean gender, int age, boolean student, boolean working, String occupation) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.student = student;
            this.working = working;
            this.occupation = occupation;
        }
    }
}
