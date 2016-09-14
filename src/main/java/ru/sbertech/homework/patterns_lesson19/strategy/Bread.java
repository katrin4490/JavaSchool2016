package ru.sbertech.homework.patterns_lesson19.strategy;

/**
 * Created by программист on 14.09.2016.
 */
public class Bread implements ProductType {
    @Override
    public int getCost() {
        return 30;
    }
}
