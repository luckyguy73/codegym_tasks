package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Mastering the static block
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String aircraft = buff.readLine();
        if (aircraft.equals("helicopter")) result = new Helicopter();
        else {
            int passengers = Integer.parseInt(buff.readLine());
            result = new Plane(passengers);
        }
        buff.close();
    }
}
