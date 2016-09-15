package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 15.09.2016.
 */
public class OffStatePrinter implements  IStatePrinter {
    private Printer printer;

    public OffStatePrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void onPrinter() {
        System.out.println("Принтер включен");
        printer.setState(new WaitingStatePrinter(this.printer));
    }

    @Override
    public void offPrinter() {
        System.out.println("Принтер уже выключен");
    }

    @Override
    public void print() {
        System.out.println("Принтер отключен. Печать невозможна");
    }

    @Override
    public void addPaper(int countPaper) {
        this.printer.addPaper(countPaper);
        System.out.println("Бумага добавлена");
    }
}
