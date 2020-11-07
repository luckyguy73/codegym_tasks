package com.codegym.task.task20.task2022;

import java.io.*;

/* 
Overriding serialization in a thread
*/

public class Solution implements Serializable, AutoCloseable {
    public static void main(String[] args) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("your_file_name_2.txt"));
             ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("your_file_name_2.txt"))) {
            Solution solution = new Solution("your_file_name_1.txt");
            solution.writeObject("some text");
            outputStream.writeObject(solution);
            outputStream.flush();
            Solution loadedObject = (Solution) objectStream.readObject();
            loadedObject.writeObject("some text - 2");
        } catch (Exception ignored) { }
    }

    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
