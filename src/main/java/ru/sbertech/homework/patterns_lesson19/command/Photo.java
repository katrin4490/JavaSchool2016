package ru.sbertech.homework.patterns_lesson19.command;


public class Photo {
    private String name;
    private String title;
    private String color = "прозрачный";
    private String effect = "отсутсвует";



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "; Title: " + getTitle() + "; Color: " + getColor() + "; Effect: = " + getEffect();
    }
}
