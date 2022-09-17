package com.codegym.task.task25.task2511;

import java.util.TimerTask;

/* 
Arming ourselves to the teeth!
*/

public class Solution extends TimerTask {

    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t, e) -> {
            StringBuilder encryptedName = new StringBuilder();
            String message = e.getMessage(), name = t.getName();
            name.chars().forEach(m -> encryptedName.append("*"));
            String encryptedMessage = message.replaceAll(name, encryptedName.toString());
            System.out.println(encryptedMessage);
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah" +
                    "-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}
