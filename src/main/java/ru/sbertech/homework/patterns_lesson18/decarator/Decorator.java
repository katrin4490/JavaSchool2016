package ru.sbertech.homework.patterns_lesson18.decarator;


abstract public class Decorator extends AbstractAnimal {
    protected IAnimal animal;

    public Decorator (IAnimal animal){
        this.animal = animal;
    }

    @Override
    public void paint(Colour colour) {
        this.animal.paint(colour);
    }

    @Override
    public Colour getColour() {
        return this.animal.getColour();
    }

    @Override
    public void say(){
        this.animal.say();
    }

    @Override
    public String getName() {
        return this.animal.getName();
    }

    @Override
    public void setName(String name) {
        this.animal.setName(name);
    }

    public String toString() {
        return (this.getClass().getSimpleName() +
                "[" +
                "name = " + this.getName() +
                ", colour = " + this.getColour() +
                "]");
    }
}
