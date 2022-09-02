package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Find all the files
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        Deque<File> folders = new ArrayDeque<>();
        folders.offer(new File(root));
        while (!folders.isEmpty()) {
            File folder = folders.poll();
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isFile()) fileTree.add(file.getAbsolutePath());
                if (file.isDirectory()) folders.add(file);
            }
        }
        return fileTree;
    }

    public static void main(String[] args) {

    }
}
