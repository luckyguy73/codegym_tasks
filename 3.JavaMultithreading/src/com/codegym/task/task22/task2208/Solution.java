package com.codegym.task.task22.task2208;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/* 
Build a WHERE query
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        params.values().removeIf(Objects::isNull);
        return params.entrySet().stream().map(e -> String.format("%s = '%s'", e.getKey(), e.getValue()))
                .collect(Collectors.joining(" and "));
    }
}
