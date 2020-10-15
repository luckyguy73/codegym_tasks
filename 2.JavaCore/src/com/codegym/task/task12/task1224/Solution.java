package com.codegym.task.task12.task1224;

/* 
Unknown animal
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //write your code here
        if (o instanceof Cat) return "Cat";
        else if (o instanceof Tiger) return "Tiger";
        else if (o instanceof Lion) return "Lion";
        else if (o instanceof Bull) return "Bull";
        return "Animal";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
