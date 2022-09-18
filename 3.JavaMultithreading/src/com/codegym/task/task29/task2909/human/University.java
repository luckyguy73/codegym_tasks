package com.codegym.task.task29.task2909.human;

import java.util.*;

public class University {

    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream().filter(s -> s.getAverageGrade() == averageGrade).findFirst().orElse(null);
    }

    public Student getStudentWithHighestAverageGrade() {
        return students.stream().max(Comparator.comparingDouble(Student::getAverageGrade)).orElse(null);
    }

    public Student getStudentWithLowestAverageGrade() {
        return students.stream().min(Comparator.comparingDouble(Student::getAverageGrade)).orElse(null);
    }

    public void expel(Student student) {
        students.removeIf(s -> s.getId() == student.getId());
    }

}
