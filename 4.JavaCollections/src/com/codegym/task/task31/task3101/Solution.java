package com.codegym.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/*
Iterating through a file tree
*/

public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            Map<String, byte[]> fileTree = getFileTree(path);
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) FileUtils.deleteFile(dest);
            FileUtils.renameFile(resultFile, dest);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                for (byte[] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException ignored) { }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));
        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private final Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile())
                if (file.length() < 51)
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
