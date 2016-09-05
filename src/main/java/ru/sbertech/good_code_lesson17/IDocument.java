package ru.sbertech.good_code_lesson17;

public interface IDocument { // надо разделить на 3 интефрейса
    public void print();

    public void printUserInfo();

    public void savetoDB();
}
