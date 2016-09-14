package ru.sbertech.homework.patterns_lesson19.strategy;


public class Sausage implements ProductType{
    @Override
    public int getCost() {
        return 500;
    }
}
