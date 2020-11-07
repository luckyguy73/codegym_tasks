package com.codegym.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Introducing properties
*/

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream input = new FileInputStream(buff.readLine())) {
            load(input);
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        properties.forEach(prop::setProperty);
        prop.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((k, v) -> properties.put(k.toString(), v.toString()));
    }

    public static void main(String[] args) {

    }
}

