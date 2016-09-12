package ru.sbertech.homework.patterns_lesson18.decarator;

public abstract class AbstractAnimal implements IAnimal {
    private IAnimal.Colour colour;
    private String name;

    public AbstractAnimal(){
        this.colour = IAnimal.Colour.UNPAINTED;
    }

    public AbstractAnimal(String name){
        this.name = name;
        this.colour = IAnimal.Colour.UNPAINTED;
    }

    @Override
    public void paint(IAnimal.Colour colour) {
        this.colour = colour;
    }

    @Override
    public IAnimal.Colour getColour() {
        return this.colour;
    }

    @Override
    public abstract void say();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
