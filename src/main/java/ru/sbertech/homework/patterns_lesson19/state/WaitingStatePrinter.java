package ru.sbertech.homework.patterns_lesson19.state;

public class WaitingStatePrinter implements  IStatePrinter {
    private Printer printer;

    public WaitingStatePrinter(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void onPrinter() {
        System.out.println("Принтер уже включен...");
    }

    @Override
    public void offPrinter() {
        System.out.println("Принтер выключен");
        this.printer.setState(new OffStatePrinter(this.printer));
    }

    @Override
    public void print() {
        if (this.printer.getCountPaper() > 0) {
            this.printer.setState(new PrintStatePrinter(this.printer));
        } else {
            this.printer.setState(new NoPaperStatePrinter(this.printer));
        }
    }

    @Override
    public void addPaper(int countPaper) {
        this.printer.addPaper(countPaper);
        System.out.println("Бумага добавлена");
    }
}
