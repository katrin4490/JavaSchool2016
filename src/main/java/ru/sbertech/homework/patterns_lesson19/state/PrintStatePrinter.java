package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 15.09.2016.
 */
public class PrintStatePrinter implements  IStatePrinter {
    private Printer printer;

    public PrintStatePrinter(Printer printer) {
        this.printer = printer;
        this.myPrint();
    }

    private void myPrint(){
        this.printer.addPaper(-1);
        System.out.println("Идет печать документа...");
        this.printer.setState(new WaitingStatePrinter(this.printer));
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
            this.myPrint();
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