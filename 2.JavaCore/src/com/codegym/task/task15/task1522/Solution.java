package com.codegym.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Reinforce the singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static { readKeyFromConsoleAndInitPlanet(); }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = read.readLine();
            switch (input) {
                case Planet.SUN: thePlanet = Sun.getInstance(); break;
                case Planet.MOON: thePlanet = Moon.getInstance(); break;
                case Planet.EARTH: thePlanet = Earth.getInstance(); break;
                default: thePlanet = null;
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}

