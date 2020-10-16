package com.codegym.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Transactionality
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        File file1 = null;
        File file2 = null;

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = new File(buff.readLine());
            file2 = new File(buff.readLine());
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedReader buff1 = new BufferedReader(new FileReader(file1));
             BufferedReader buff2 = new BufferedReader(new FileReader(file2))) {
            allLines = buff1.lines().collect(Collectors.toList());
            linesForRemoval = buff2.lines().collect(Collectors.toList());
        } catch (IOException | NullPointerException e) { System.out.println("Problem with file"); }

        try {
            solution.joinData();
        } catch (CorruptedDataException ignored) { System.out.println("Corrupted Data"); }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(linesForRemoval)) allLines.removeAll(linesForRemoval);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
