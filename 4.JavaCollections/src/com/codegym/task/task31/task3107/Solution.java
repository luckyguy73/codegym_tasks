package com.codegym.task.task31.task3107;

/* 
Null object pattern
*/

import java.nio.file.*;

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path path = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path), Files.isDirectory(path), Files.isWritable(path));
        } catch (Exception e) { fileData = new NullFileData(e); }
    }

    public FileData getFileData() {
        return fileData;
    }
}
