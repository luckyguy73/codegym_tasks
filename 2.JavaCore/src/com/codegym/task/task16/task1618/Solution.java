package com.codegym.task.task16.task1618;

/* 
Another interruption

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread thread = new TestThread();
        thread.start();
        thread.interrupt();
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {

        }
    }
}



