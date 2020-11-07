package com.codegym.task.task20.task2021;

import java.io.*;

/* 
Serialization is prohibited
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException("nope");
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException("nope");
        }
    }

    public static void main(String[] args) {

    }
}
