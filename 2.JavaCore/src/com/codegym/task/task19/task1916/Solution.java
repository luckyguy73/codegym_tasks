package com.codegym.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Tracking changes
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> one = new ArrayList<>(), two = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader a = new BufferedReader(new FileReader(buff.readLine()));
             BufferedReader b = new BufferedReader(new FileReader(buff.readLine()))) {
            while (a.ready()) one.add(a.readLine());
            while (b.ready()) two.add(b.readLine());
        }
        int oneIndex = 0, twoIndex = 0;
        while (oneIndex < one.size() && twoIndex < two.size()) {
            String a = one.get(oneIndex), b = two.get(twoIndex);
            if (a.equals(b)) {
                lines.add(new LineItem(Type.SAME, a));
                oneIndex++;
                twoIndex++;
            }
            else if (oneIndex + 1 < one.size() && one.get(oneIndex + 1).equals(b)) {
                lines.add(new LineItem(Type.REMOVED, a));
                oneIndex++;
            } else if (twoIndex + 1 < two.size() && two.get(twoIndex + 1).equals(a)) {
                lines.add(new LineItem(Type.ADDED, b));
                twoIndex++;
            }
        }
        while (oneIndex < one.size()) lines.add(new LineItem(Type.REMOVED, one.get(oneIndex++)));
        while (twoIndex < two.size()) lines.add(new LineItem(Type.ADDED, two.get(twoIndex++)));
    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}


