package ru.sbertech.homework.reflection_lesson6;

/**
 * Created by программист on 01.08.2016.
 */
public class A {
    int h;
    private static final String s1 = "s1";
    public static final String s2 = "s2";

    private static String s3 = "s3";
    public static final String s4 = "s5";
    public static String s6 = "s6";

    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }

    public int calc() {
        return 1+1;
    }


}
