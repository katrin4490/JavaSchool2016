package ru.sbertech.homework.concurrent_lesson14;

import java.util.concurrent.Callable;


public class CalculatorCallable implements Callable {

    private int a;
    private int b;
    Calc c;

    public CalculatorCallable(Calc c, int a, int b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }

    @Override
    public Object call() throws Exception {
        return c.calculate(a, b);
    }

}
