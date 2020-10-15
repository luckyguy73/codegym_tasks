package com.codegym.task.task12.task1220;

/* 
Human class and CanRun and CanSwim interfaces
*/

public class Solution {
    public static void main(String[] args) {

    }

    // Add public interfaces and a public class here
    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public abstract class Human implements CanRun, CanSwim {

    }
}
