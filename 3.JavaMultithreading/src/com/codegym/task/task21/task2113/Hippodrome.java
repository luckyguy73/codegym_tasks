package com.codegym.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>(Arrays.asList(new Horse("Ash", 3, 0),
                new Horse("Authentic", 3, 0), new Horse("Secretariat", 3, 0)));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 1; i < 101; ++i) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) { }
        }
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; ++i) System.out.println();
    }

    public Horse getWinner() {
        return horses.stream().reduce((a, b) -> a.getDistance() >= b.getDistance() ? a : b).orElse(null);
    }

    public void printWinner() {
        System.out.printf("The winner is %s!%n", getWinner().getName());
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
