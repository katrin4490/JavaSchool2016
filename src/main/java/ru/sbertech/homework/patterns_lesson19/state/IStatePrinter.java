package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 15.09.2016.
 */
public interface IStatePrinter {
    void onPrinter();
    void offPrinter();
    void print();
    void addPaper(int countPaper);
}
