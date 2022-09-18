package com.codegym.task.task26.task2603;

/* 
A convert can easily convert others
*/

import java.util.Comparator;

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {

        private final Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T t, T t1) {
            int result = 0;
            for (Comparator<T> comparator : comparators)
                if ((result = comparator.compare(t, t1)) != 0) break;

            return result;
        }

    }

    public static void main(String[] args) {

    }

}
