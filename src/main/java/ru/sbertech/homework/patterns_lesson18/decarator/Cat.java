package ru.sbertech.homework.patterns_lesson18.decarator;


public class Cat extends AbstractAnimal {

    public Cat(){
        super();
    }

    public Cat(String name){
       super(name);
    }

    @Override
    public void say(){
        System.out.println("Мяу!");
    }

}
