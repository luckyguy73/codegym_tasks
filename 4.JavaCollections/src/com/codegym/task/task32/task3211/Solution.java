package com.codegym.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Data integrity
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject("test string");
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        mdAlgorithm.update(byteArrayOutputStream.toByteArray());
        byte[] digest = mdAlgorithm.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String x = Integer.toHexString(0xFF & b);
            if (x.length() < 2) x = "0" + x;
            hexString.append(x);
        }
        return hexString.toString().equals(md5);
    }
}
