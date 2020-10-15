package com.codegym.task.task15.task1521;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.printf("Tree No. %d , Object method, parameter: %s%n", number, s.getClass().getSimpleName());
    }
    public void info(Number s) {
        System.out.printf("Tree No. %d , Number method, parameter: %s%n", number, s.getClass().getSimpleName());
    }
    public void info(String s) {
        System.out.printf("Tree No. %d , String method, parameter: %s%n", number, s.getClass().getSimpleName());
    }
}
