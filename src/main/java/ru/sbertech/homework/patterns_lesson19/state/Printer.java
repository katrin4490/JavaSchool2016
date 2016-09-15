package ru.sbertech.homework.patterns_lesson19.state;

/**
 * Created by программист on 15.09.2016.
 */
public class Printer {

    private IStatePrinter statePrinter;
    private int countPaper = 0;

    public Printer (){
        this.statePrinter = new OffStatePrinter(this);
    }

    public void setState(IStatePrinter state) {
        this.statePrinter = state;
    }

    public int getCountPaper() {
        return countPaper;
    }

    public void addPaper(int countPaper) {
        this.countPaper += countPaper;
    }

    public void printDocument(){
        this.statePrinter.print();
    }

    public void onn(){
        this.statePrinter.onPrinter();
    }

    public void off(){
        this.statePrinter.offPrinter();
    }

}
