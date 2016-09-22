package ru.sbertech.homework.reflection_lesson6;


public class Calculator  implements Calc{

    @Override
    public Object calculate(int a, int b){
        return a+b;
    }
}