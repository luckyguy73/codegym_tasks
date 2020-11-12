package com.codegym.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution a = new Solution(), b = new Solution();
        a.innerClasses = new InnerClass[] {a.new InnerClass(), a.new InnerClass()};
        b.innerClasses = new InnerClass[] {b.new InnerClass(), b.new InnerClass()};
        return new Solution[] {a, b};
    }

    public static void main(String[] args) {
    }
}
