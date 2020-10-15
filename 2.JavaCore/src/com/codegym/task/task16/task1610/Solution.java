package com.codegym.task.task16.task1610;

/* 
Arranging calls to join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Missy");
        Cat cat2 = new Cat("Coco");
    }

    private static void investigateWorld() throws InterruptedException {
        Thread.sleep(200);
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) throws InterruptedException {
            super(name);
            kitten1 = new Kitten("Kitten 1 (mother - " + getName() + ")");
            kitten2 = new Kitten("Kitten 2 (mother - " + getName() + ")");
            start();
        }

        public void run() {
            System.out.println(getName() + " gave birth to 2 kittens");
            try {
                initAllKittens();
            } catch (InterruptedException ignored) { }
            System.out.println(getName() + ": All the kittens are in the basket. " + getName() + " brought them back");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten2.start();
            kitten1.join();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + " got out of the basket");
            try {
                investigateWorld();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
