package ru.sbertech.homework.classloader_lesson7;

public class Plugin1 implements IPlugin {
    @Override
    public void doUsefull(){
        System.out.println("I'm System");
        A a = new A();
        a.info();
    }
}