package ru.sbertech.homework.concurrent_lesson14;

public class Calculator  implements Calc {
    @Override
    public int calculate(int a, int b){
        return a+b;
    }
}
