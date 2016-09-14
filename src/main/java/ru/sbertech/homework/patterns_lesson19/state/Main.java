package ru.sbertech.homework.patterns_lesson19.state;

public class Main {
    public static void main(String[] args) {
        Year year = new Year(new Autumn());
        System.out.println(year.toString());

        year.nextSeason();
        System.out.println(year.toString());

        year.nextSeason();
        System.out.println(year.toString());

        year.backSeason();
        System.out.println(year.toString());
    }
}
