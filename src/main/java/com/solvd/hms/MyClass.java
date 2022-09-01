package com.solvd.hms;

public class MyClass {
    private static String name1 = "Olya";
    private static String name2 = "Lena";

    public static void changePlace() {

        synchronized (MyClass.class) {
            String s = name1;
            name1 = name2;
            name2 = s;
        }
    }
}
