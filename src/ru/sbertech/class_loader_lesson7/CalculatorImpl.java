package ru.sbertech.class_loader_lesson7;

/**
 * Created by Student on 01.08.2016.
 */
public class CalculatorImpl implements Calculator {
    @Override
    public void calc(){
        System.out.println("Calc from System classloader");
    }
}
