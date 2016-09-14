package ru.sbertech.homework.patterns_lesson19.state;

public interface Season {
    void next(Year year);
    void back(Year year);
}
