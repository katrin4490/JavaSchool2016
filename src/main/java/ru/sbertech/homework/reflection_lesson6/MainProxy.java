package ru.sbertech.homework.reflection_lesson6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by программист on 01.08.2016.
 */
public class MainProxy {
    public static void main(String[] args) {
        Calc c = new Calculator();
        c = CachedProxy.create(Calc.class, c);

        System.out.println(c.calculate(3,4));

        System.out.println(c.calculate(2,1));

        System.out.println(c.calculate(4,4));

        System.out.println(c.calculate(3,4));

        System.out.println(c.calculate(3,4));

        System.out.println(c.calculate(4,4));


    }
}
