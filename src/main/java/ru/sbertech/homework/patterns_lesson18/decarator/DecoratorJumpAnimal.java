package ru.sbertech.homework.patterns_lesson18.decarator;


public class DecoratorJumpAnimal extends Decorator{
    public DecoratorJumpAnimal(IAnimal animal){
        super(animal);
        super.setName(animal.getName() + ". Я умею " + this.jump());
    }

    private String jump(){
        return  "прыгать";
    }
}
