package ru.sbertech.reflection_lesson6;

/**
 * Created by Student on 28.07.2016.
 */
public class A {
    public void mA() {};

    public void pubA(String str) {
        System.out.println("From A " + str);
    };

    private void priA(String str) {
        System.out.println("From A " + str);
    };
}
