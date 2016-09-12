package ru.sbertech.homework.patterns_lesson18.decarator;


public class DecoratorFlyAnimal extends Decorator {
    public DecoratorFlyAnimal(IAnimal animal){
        super(animal);
        super.setName(animal.getName() + ". Я умею " + this.fly());
    }

    private String fly(){
        return  "летать";
    }
}
