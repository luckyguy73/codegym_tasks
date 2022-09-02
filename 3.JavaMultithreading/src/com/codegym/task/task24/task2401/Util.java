package com.codegym.task.task24.task2401;

import java.lang.reflect.Method;

public class Util {
    public static void testClass(SelfMarkerInterface interfaceMarker) throws UnsupportedMarkerInterfaceException {
        if (interfaceMarker == null) throw new UnsupportedMarkerInterfaceException("Parameter is null");

        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
