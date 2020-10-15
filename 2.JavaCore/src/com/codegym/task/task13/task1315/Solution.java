package com.codegym.task.task13.task1315;

/* 
Tom, Jerry and Spike
*/

public class Solution {
    public static void main(String[] args) {

    }

    // Can move
    public interface CanMove {
        void move();
    }

    // Can be eaten
    public interface Edible {
        void beEaten();
    }

    // Can eat
    public interface CanEat {
        void eat();
    }

    class Dog implements CanMove, CanEat {

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    class Cat implements CanMove, CanEat, Edible {

        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void eat() {

        }
    }

    class Mouse implements CanMove, Edible {

        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
}