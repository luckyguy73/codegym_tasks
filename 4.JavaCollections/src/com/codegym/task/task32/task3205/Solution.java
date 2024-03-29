package com.codegym.task.task32.task3205;

import java.lang.reflect.Proxy;

/*
Creating a proxy object

*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods original = new SomeInterfaceWithMethodsImpl();

        ClassLoader classLoader = SomeInterfaceWithMethods.class.getClassLoader();
        Class[] interfaces = {SomeInterfaceWithMethods.class};
        CustomInvocationHandler handler = new CustomInvocationHandler(original);

        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
