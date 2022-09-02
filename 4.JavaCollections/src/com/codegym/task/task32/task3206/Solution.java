package com.codegym.task.task32.task3206;

import java.lang.reflect.Proxy;

/* 
Generics for creating a proxy object

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        // true false false
        test(solution.getProxy(Item.class, Small.class));           // true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));// true true true
        test(solution.getProxy(Big.class, Small.class));            // true true true, because Big inherits Item
        test(solution.getProxy(Big.class));                         // true true false, because Big inherits Item
    }

    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }

    public <T extends Item> T getProxy(Class<T> type, Class<?>... additionalInterfaces) {
        Class<?>[] interfaces = new Class<?>[additionalInterfaces.length + 1];
        interfaces[0] = type;
        System.arraycopy(additionalInterfaces, 0, interfaces, 1, additionalInterfaces.length);
        Object instance = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                interfaces,
                new ItemInvocationHandler());
        return (T) instance;
    }
}
