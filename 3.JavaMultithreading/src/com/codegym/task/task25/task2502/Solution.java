package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!

*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();
            Arrays.stream(loadWheelNamesFromDB()).forEach(m -> wheels.add(Wheel.valueOf(m)));
            if (loadWheelNamesFromDB().length != 4) throw new IllegalArgumentException();
        }

        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
