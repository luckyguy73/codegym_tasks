package com.codegym.task.task31.task3104;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/*
Search for hidden files
*/

public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:/"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) System.out.println("\t" + path);

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) System.out.println("\t" + path);
    }

    private List<String> archived = new ArrayList<>(), failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (path.toString().endsWith(".rar") || path.toString().endsWith(".zip")) archived.add(path.toString());
        return super.visitFile(path, basicFileAttributes);
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
        failed.add(path.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }
}
