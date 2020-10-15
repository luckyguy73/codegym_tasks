package com.codegym.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Decrease").start();
        new Thread(new CountUpRunnable(), "Increase").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countUpIndex = 1;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    Thread.sleep(500);
                    if (++countUpIndex > Solution.number) return;
                }
            } catch (InterruptedException ignored) { }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countUpIndex;
        }
    }

    public static class CountdownRunnable implements Runnable {
        private int countDownIndex = Solution.number;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    if (--countDownIndex == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException ignored) { }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countDownIndex;
        }
    }
}
