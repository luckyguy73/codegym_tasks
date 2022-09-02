package com.codegym.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
File downloader
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://codegym.cc/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        Files.readAllLines(passwords).forEach(System.out::println);
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
        Path downloadPath = downloadDirectory.resolve(fileName);
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile("temp", ".tmp");
        Files.copy(inputStream, tempFile);
        Files.move(tempFile, downloadPath);
        return downloadPath;
    }
}
