package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    public static List<Student> students = new ArrayList<>();

    public static void addStudentInfo(Student student) {
        students.add(student);
        printStudentInfo(student);
    }

    public static void printStudentInfo(Student student) {
        System.out.println("Name: " + student.getName() + " Age: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if (index >= 0 && index < students.size()) students.remove(index);
    }

    public static void findJohnOrAlex() {
        for (Student student : students) {
            if (student.getName().equals("John")) {
                System.out.println("John is in the student database.");
                break;
            }

            if (student.getName().equals("Alex")) {
                System.out.println("Alex is in the student database.");
                break;
            }
        }
    }
}
