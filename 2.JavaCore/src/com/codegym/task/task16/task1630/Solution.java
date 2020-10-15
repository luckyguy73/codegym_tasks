package com.codegym.task.task16.task1630;

import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = buff.readLine();
            secondFileName = buff.readLine();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName;
        String fileContents = "";

        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public void run() {
            try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
                fileContents = buff.lines().collect(Collectors.joining(" "));
            } catch (IOException e) { e.printStackTrace(); }
        }

        @Override
        public String getFileContents() {
            return fileContents;
        }
    }
}
