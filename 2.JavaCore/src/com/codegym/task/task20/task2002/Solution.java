package com.codegym.task.task20.task2002;

import java.io.*;
import java.util.*;

/*
Reading and writing to a file: CodeGym
*/

public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            System.out.println(codeGym.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) { System.out.println("Oops, something wrong with my file"); } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            try (PrintWriter printWriter = new PrintWriter(outputStream)) {
                for (User current : this.users) {
                    String user = current.getFirstName() + "/" + current.getLastName() + "/" +
                        current.getBirthDate().getTime() + "/" + current.isMale() + "/" + current.getCountry();
                    printWriter.println(user);
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = buff.readLine()) != null) {
                    User user = new User();
                    String[] lineArray = line.split("/");
                    if (lineArray.length < 5) continue;
                    user.setFirstName(lineArray[0]);
                    user.setLastName(lineArray[1]);
                    user.setBirthDate(new Date(Long.parseLong(lineArray[2])));
                    user.setMale(Boolean.parseBoolean(lineArray[3]));
                    switch (lineArray[4]) {
                        case "UNITED_STATES": user.setCountry(User.Country.UNITED_STATES); break;
                        case "UNITED_KINGDOM": user.setCountry(User.Country.UNITED_KINGDOM); break;
                        default: user.setCountry(User.Country.OTHER);
                    }
                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CodeGym codeGym = (CodeGym) o;
            return Objects.equals(users, codeGym.users);
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
