package com.codegym.task.task21.task2107;

import java.util.*;

/* 
Deep cloning of a map
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution s = (Solution) super.clone();
        Map<String, User> map = new LinkedHashMap<>();
        for (Map.Entry<String, User> user : users.entrySet()) map.put(user.getKey(), user.getValue());
        s.users = map;
        return s;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            if (age != user.age) return false;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return 31 * age + (name != null ? name.hashCode() : 0);
        }
    }
}
