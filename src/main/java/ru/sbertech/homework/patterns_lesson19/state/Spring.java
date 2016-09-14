package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 14.09.2016.
 */
public class Spring implements Season {
    @Override
    public void next(Year year) {
        year.season = new Summer();
    }

    @Override
    public void back(Year year) {
        year.season = new Winter();
    }
    @Override
    public String toString() {
        return "Весна";
    }
}