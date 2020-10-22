package com.codegym.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
Yet another adapter
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String[] props = fileScanner.nextLine().split("\\s+");
            SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
            Date bd = null;
            try {
                bd = format.parse(props[3] + props[4] + props[5]);
            } catch (ParseException e) { e.printStackTrace(); }
            return new Person(props[2], props[0], props[1], bd);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}




