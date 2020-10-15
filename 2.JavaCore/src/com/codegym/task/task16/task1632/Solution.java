package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        for (int i = 1; i <= 5; ++i) {
            try {
                threads.add((Thread) Class.forName("com.codegym.task.task16.task1632.Solution$Thread" + i).newInstance());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ignored) { }
        }
    }

    public static void main(String[] args) {
        threads.forEach(Thread::start);
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
    public static class Thread2 extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {

            }
            System.out.println("InterruptedException");
        }
    }
    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Hurray");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) { }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    public static class Thread5 extends Thread {
        @Override
        public void run() {
            int sum = 0;
            try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                while (!(line = buff.readLine()).equals("N")) sum += Integer.parseInt(line);
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

