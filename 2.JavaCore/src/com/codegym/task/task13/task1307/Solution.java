package com.codegym.task.task13.task1307;

/* 
Parameterized interface
*/

public class Solution {
    public static void main(String[] args) {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject implements SimpleObject<String> {
        @Override
        public SimpleObject<String> getInstance() {
            return null;
        }
    }
}

