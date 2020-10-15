package com.codegym.task.task16.task1613;

/* 
Big Ben
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("London", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private final String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) printTime();
            } catch (InterruptedException ignored) { }
        }

        private void printTime() throws InterruptedException {
            Thread.sleep(1000);
            if (++seconds > 59) {
                minutes += seconds / 60;
                seconds = seconds % 60;
            }
            if (minutes > 59) {
                hours += minutes / 60;
                minutes = minutes % 60;
            }
            hours = hours % 24;
            if (hours == 0 && minutes == 0 && seconds == 0)
                System.out.printf("It's currently midnight in %s!%n", cityName);
            else System.out.printf("In %s, the time is now %02d:%02d:%02d!%n", cityName, hours, minutes, seconds);
        }
    }
}
