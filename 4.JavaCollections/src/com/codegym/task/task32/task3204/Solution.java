package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Password generator
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        int passwordLength = 8;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        List<Character> queue = new ArrayList<>();
        generateRequiredMinimums(queue);
        generateRemainingCharacters(queue, passwordLength);
        Collections.shuffle(queue);
        String password = queue.stream().map(Object::toString).collect(Collectors.joining());
        out.write(password.getBytes());
        return out;
    }

    private static void generateRequiredMinimums(List<Character> storage) {
        storage.add(generateNumber());
        storage.add(generateLowerCase());
        storage.add(generateUpperCase());
    }

    private static char generateNumber() {
        return generateCharacterWithinRange(48, 58);
    }

    private static char generateLowerCase() {
        return generateCharacterWithinRange(97, 123);
    }

    private static char generateUpperCase() {
        return generateCharacterWithinRange(65, 91);
    }

    private static char generateCharacterWithinRange(int start, int end) {
        return (char)(new Random().nextInt(end - start) + start);
    }

    private static void generateRemainingCharacters(List<Character> queue, int passwordLength) {
        for (int i = 0; i < passwordLength - 3; ++i) {
            char c;
            int index = new Random().nextInt(3);
            switch (index) {
                case 0: c = generateNumber(); break;
                case 1: c = generateLowerCase(); break;
                default: c = generateUpperCase();
            }
            queue.add(c);
        }
    }
}
