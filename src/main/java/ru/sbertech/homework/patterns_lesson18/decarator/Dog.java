package ru.sbertech.homework.patterns_lesson18.decarator;


public class Dog extends AbstractAnimal {
    public Dog(){
        super();
    }

    public Dog(String name){
        super(name);
    }

    @Override
    public void say(){
        System.out.println("Гав!");
    }
}
