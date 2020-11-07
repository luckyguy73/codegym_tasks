package com.codegym.task.task20.task2005;

import java.io.*;
import java.util.*;

/*
Stranger things
*/

public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            Human smith = new Human ("Smith", new Asset ("home"), new Asset ("car"));
            smith.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(smith.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (!Objects.equals(name, human.name)) return false;
            return Objects.equals(assets, human.assets);

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) this.assets.addAll(Arrays.asList(assets));
        }

        public void save(OutputStream outputStream) throws Exception {
            try (PrintWriter printWriter = new PrintWriter(outputStream)) {
                printWriter.println(this.name);
                for (Asset current : this.assets) printWriter.println(current.getName());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                this.name = reader.readLine();
                String assetName;
                while ((assetName = reader.readLine()) != null) this.assets.add(new Asset(assetName));
            }
        }
    }
}



