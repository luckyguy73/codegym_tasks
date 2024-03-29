package com.codegym.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

@SuppressWarnings("GrazieInspection")
public abstract class SocketTask<T> implements CancellableTask<T> {

    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        // Close all resources here
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public RunnableFuture<T> newTask() {

        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                // Close all resources here using the proper SocketTask method
                // Call the superclass's method in a finally block
                try {
                    SocketTask.this.cancel();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                finally {
                    super.cancel(mayInterruptIfRunning);
                }
                return mayInterruptIfRunning;
            }
        };

    }

}
