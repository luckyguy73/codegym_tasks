package com.codegym.task.task25.task2510;

/* 
Wait and see
*/

public class Solution extends Thread {

    public Solution() {

        Thread thread = this;
        thread.setUncaughtExceptionHandler((t, e) -> {
            if ( e instanceof Error) System.out.println("Can't keep running");
            else if ( e instanceof Exception) System.out.println("Needs handling");
            else if (e != null) System.out.println("Wait and see");
        });

    }

    public static void main(String[] args) {

    }

}
