package com.codegym.task.task16.task1617;

/* 
Countdown at the races
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (!isInterrupted() && numSeconds > 0) {
                    System.out.print(numSeconds-- + " ");
                    Thread.sleep(1000);
                }
                System.out.println("Go!");
            } catch (InterruptedException e) { System.out.println("Interrupted!"); }
        }
    }
}
