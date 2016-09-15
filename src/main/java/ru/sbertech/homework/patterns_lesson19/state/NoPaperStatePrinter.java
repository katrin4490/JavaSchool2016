package ru.sbertech.homework.patterns_lesson19.state;


public class NoPaperStatePrinter implements  IStatePrinter {
    private Printer printer;

    public NoPaperStatePrinter(Printer printer) {
        this.printer = printer;
        System.out.println("Закончилась бумага...");
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
            System.out.println("Закончилась бумага...");
        }
    }

    @Override
    public void addPaper(int countPaper) {
        this.printer.addPaper(countPaper);
        System.out.println("Бумага добавлена");
        if (this.printer.getCountPaper() > 0){
            this.printer.setState(new WaitingStatePrinter(this.printer));
        }
    }
}
