package com.codegym.task.task21.task2101;

/* 
Determine the network address
*/

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] net = new byte[ip.length];
        for (int i = 0; i < ip.length; ++i) net[i] = (byte) (ip[i] & mask[i]);
        return net;
    }

    public static void print(byte[] bytes) {
        int[] ints = new int[bytes.length];
        for (int i = 0; i < bytes.length; ++i) ints[i] = bytes[i];
        for (int i = 0; i < ints.length; ++i) if (ints[i] < 0) ints[i] += 1 << 8;
        String s = Arrays.stream(ints).mapToObj(o -> String.format("%08d", Integer.valueOf(Integer.toBinaryString(o))))
                         .collect(Collectors.joining(" "));
        System.out.println(s);
    }
}

/*
11000000
00111111
01000000
 */