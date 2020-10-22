package com.codegym.task.task19.task1915;

/* 
Duplicate text
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String file;
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file = buff.readLine();
        }
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        System.out.println(result);
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(result.getBytes());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}

