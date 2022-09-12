package com.codegym.task.task25.task2504;

/* 
A switch for threads
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        // Implement this method
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW: thread.start(); break;
                case BLOCKED:
                case TIMED_WAITING:
                case WAITING: thread.interrupt(); break;
                case RUNNABLE: thread.isInterrupted(); break;
                case TERMINATED: System.out.println(thread.getPriority()); break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
