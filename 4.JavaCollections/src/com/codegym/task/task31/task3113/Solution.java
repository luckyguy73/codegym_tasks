package com.codegym.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import static java.nio.file.FileVisitResult.CONTINUE;

/*
What's in the folder?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path directory;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            directory = Paths.get(reader.readLine());
        }

        if (!Files.isDirectory(directory)) System.out.println(directory.toString() + " is not a folder");
        else {
            AtomicInteger folderCounter = new AtomicInteger(), fileCounter = new AtomicInteger();
            AtomicLong sizeCounter = new AtomicLong();

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(directory)) folderCounter.incrementAndGet();
                    return CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCounter.incrementAndGet();
                    sizeCounter.addAndGet(attrs.size());
                    return CONTINUE;
                }
            });

            System.out.println("Total folders: " + folderCounter.get());
            System.out.println("Total files: " + fileCounter.get());
            System.out.println("Total size: " + sizeCounter.get() + " bytes");
        }
    }
}
