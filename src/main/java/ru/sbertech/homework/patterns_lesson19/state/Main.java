package ru.sbertech.homework.patterns_lesson19.state;

// Используется в тех случаях, когда во время выполнения программы объект
// должен менять своё поведение в зависимости от своего состояния.


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.onn();
        printer.printDocument();
        printer.addPaper(5);
        printer.printDocument();
        printer.printDocument();
        printer.printDocument();
        printer.printDocument();
        printer.printDocument();

        printer.printDocument();
        printer.printDocument();
        printer.off();;
        printer.onn();

        printer.printDocument();
        printer.addPaper(2);
        printer.printDocument();
        printer.printDocument();
    }
}
