package com.codegym.task.task19.task1918;

/* 
Introducing tags
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader input = new BufferedReader(new FileReader(buff.readLine()))) {
//            while (input.ready()) sb.append(input.readLine());
//        }
//        Pattern pattern = Pattern.compile("<" + args[0] + ".*?>.*<\\/" + args[0] + ">", Pattern.MULTILINE);
//        Matcher m = pattern.matcher(sb.toString().replaceAll("\n", ""));
//        while (m.find()) System.out.println(m.group());
//    }
//}


public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        }

        StringBuilder readFileContent = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) readFileContent.append(fileReader.readLine());
        }

        String fileContent = readFileContent.toString().replaceAll("\r\n", "");
        String openTag = "<" + args[0], closingTag = "</" + args[0];

        int tagLength = args[0].length(), startTagIndex = 0, endTagIndex;

        ArrayList<String> tags = new ArrayList<>();

        while ((startTagIndex != -1) && (startTagIndex < fileContent.length())) {
            startTagIndex = fileContent.indexOf(openTag, startTagIndex);
            endTagIndex = fileContent.indexOf(closingTag, startTagIndex + tagLength);

            int indexInTag = startTagIndex + tagLength;
            if (endTagIndex != -1) {
                while (fileContent.substring(indexInTag, endTagIndex).contains(openTag)) {
                    indexInTag = endTagIndex + tagLength;
                    endTagIndex = fileContent.indexOf(closingTag, indexInTag);
                }
            }
            if (startTagIndex != -1 && endTagIndex != -1) {
                tags.add(fileContent.substring(startTagIndex, endTagIndex + tagLength + 3));
                startTagIndex += tagLength;
            }
        }

        for (String tag : tags) System.out.println(tag);
    }
}

