package com.codegym.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
So, let's... compare
*/

public class Solution {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
    }

    public static class C extends ArrayDeque {
        @Override
        public ArrayDeque clone() {
            return super.clone();
        }
    }

    public static class D implements EventListener {
    }

    public static void main(String[] args) {

    }
}
