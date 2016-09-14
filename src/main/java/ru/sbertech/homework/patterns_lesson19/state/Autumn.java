package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 14.09.2016.
 */
public class Autumn implements Season {
    @Override
    public void next(Year year) {
        year.season = new Winter();
    }

    @Override
    public void back(Year year) {
        year.season = new Summer();
    }
    @Override
    public String toString() {
        return "Осень";
    }
}
