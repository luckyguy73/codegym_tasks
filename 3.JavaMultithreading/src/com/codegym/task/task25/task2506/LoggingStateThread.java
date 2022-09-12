package com.codegym.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private final Thread thread;
    State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        super.run();
        while (state != State.TERMINATED) {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(state);
            }
        }

    }

}
