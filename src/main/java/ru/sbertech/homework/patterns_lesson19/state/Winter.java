package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 14.09.2016.
 */
public class Winter implements Season {
    @Override
    public void next(Year year) {
        year.season = new Spring();
    }

    @Override
    public void back(Year year) {
        year.season = new Autumn();
    }
    @Override
    public String toString() {
        return "Зима";
    }
}
