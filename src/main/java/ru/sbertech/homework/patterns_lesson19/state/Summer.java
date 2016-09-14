package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 14.09.2016.
 */
public class Summer implements Season {
    @Override
    public void next(Year year) {
        year.season = new Autumn();
    }

    @Override
    public void back(Year year) {
        year.season = new Spring();
    }

    @Override
    public String toString() {
        return "Лето";
    }
}
