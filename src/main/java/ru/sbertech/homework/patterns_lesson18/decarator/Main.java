package ru.sbertech.homework.patterns_lesson18.decarator;

public class Main {
    public static void main(String[] args) {
        IAnimal animalCat = new Cat("Барсик");
        animalCat = new DecoratorFlyAnimal(animalCat);
        animalCat.paint(IAnimal.Colour.BLACK);
        System.out.println(animalCat.toString());

        animalCat = new DecoratorJumpAnimal(animalCat);
        System.out.println(animalCat.toString());

        System.out.println("----------------------------");

        IAnimal animalDog = new Dog("Рекс");
        animalDog = new DecoratorRunAnimal(animalDog);
        System.out.println(animalDog.toString());

        animalDog = new DecoratorJumpAnimal(animalDog);
        System.out.println(animalDog.toString());
    }
}
