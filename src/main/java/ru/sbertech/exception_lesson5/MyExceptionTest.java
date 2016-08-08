package ru.sbertech.exception_lesson5;

class MyException extends RuntimeException {
}

public class MyExceptionTest extends Exception{
    public static void main (String[] args) {
        throw  new MyException();
    }
}
