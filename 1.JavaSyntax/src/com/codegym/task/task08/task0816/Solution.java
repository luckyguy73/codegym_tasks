package com.codegym.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Kind Emma and the summer holidays
*/

public class Solution {
    public static DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);

    public static HashMap<String, Date> createMap() throws ParseException {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", df.parse("JULY 6 1946"));
        map.put("Cruise", df.parse("JULY 3 1962"));
        map.put("Pitt", df.parse("DECEMBER 18 1963"));
        map.put("Morgan", df.parse("APRIL 6 1973"));
        map.put("Freeman", df.parse("JUNE 1 1937"));
        map.put("Washington", df.parse("DECEMBER 28 1954"));
        map.put("Alba", df.parse("APRIL 28 1981"));
        map.put("Longoria", df.parse("MARCH 15 1975"));
        map.put("Vergara", df.parse("JULY 10 1972"));
        map.put("Saldana", df.parse("JUNE 19 1978"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Set<Integer> summer = new HashSet<>(Arrays.asList(5, 6, 7));
        Set<Map.Entry<String, Date>> setOfEntries = map.entrySet();
        Iterator<Map.Entry<String, Date>> iterator = setOfEntries.iterator();
        while (iterator.hasNext()) {
            Date value = iterator.next().getValue();
            if (summer.contains(value.getMonth())) iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {

    }
}
