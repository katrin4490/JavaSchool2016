package ru.sbertech.homework.patterns_lesson18.decarator;

public interface IAnimal {

    public String name = "unknown name";
    public enum Colour {UNPAINTED, BLUE, BLACK, GREEN,
        RED, SILVER, WHITE, YELLOW};

    public void paint(IAnimal.Colour colour);
    public IAnimal.Colour getColour();
    public void say();
    public String getName();
    public void setName(String name);
}
