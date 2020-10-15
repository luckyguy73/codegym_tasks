package com.codegym.task.task15.task1516;

/* 
Default values
*/

import java.lang.reflect.Field;

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;
    public static void main(String[] args) throws IllegalAccessException {
        Solution solution = new Solution();
        for(Field f : Solution.class.getFields()) System.out.println(f.get(solution));
    }
}

