package ru.sbertech.homework.JDBC_lesson21;

import ru.sbertech.homework.reflection_lesson6.Calc;
import ru.sbertech.homework.reflection_lesson6.Calculator;

public class Main {
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
