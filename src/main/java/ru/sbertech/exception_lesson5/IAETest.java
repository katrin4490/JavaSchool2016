package ru.sbertech.exception_lesson5;


class SBTEmployee{
    public  SBTEmployee (int grade){
        if ((grade < 0) || (grade > 16)){
            throw new IllegalArgumentException();
        }
    }
}

public class IAETest {
    public static void main (String[] args) {
        SBTEmployee sbtEmployee1 = new SBTEmployee(2);
        SBTEmployee sbtEmployee2 = new SBTEmployee(20);
    }
}
