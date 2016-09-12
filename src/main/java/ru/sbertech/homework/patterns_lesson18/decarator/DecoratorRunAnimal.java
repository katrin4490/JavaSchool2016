package ru.sbertech.homework.patterns_lesson18.decarator;

public class DecoratorRunAnimal extends Decorator{
    public DecoratorRunAnimal(IAnimal animal){
        super(animal);
        super.setName(animal.getName() + ". Я умею " + this.run());
    }

    private String run(){
        return  "бегать";
    }
}