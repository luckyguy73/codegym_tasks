package com.codegym.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

/*
Reading config files
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/codegym/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/codegym/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/codegym/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);
        try (InputStream is = new FileInputStream(fileName)) {
            String ext = getExtension(path.getFileName().toString());
            if ("xml".equals(ext)) properties.loadFromXML(is);
            else properties.load(is);
        } catch (IOException ignored) { }
        return properties;
    }

    public String getExtension(String filename) {
        String ext = null;
        Optional<String> string = Optional.ofNullable(filename).filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
        if (string.isPresent()) ext = string.get();
        return ext;
    }
}
