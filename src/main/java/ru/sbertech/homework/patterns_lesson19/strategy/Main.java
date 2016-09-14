package ru.sbertech.homework.patterns_lesson19.strategy;

// паттерн стратегия
// Позволяет инкапсулировать алгоритм в отдельный класс, иметь возможность менять конкретную стратегию в рантайме.

public class Main {
    public static void main(String[] args) {
        Product product = new Product(new Cheese());
        System.out.println(product.getNameType() + ", cost = " + product.getCost());

        Product product2 = new Product(new Bread());
        System.out.println(product2.getNameType() + ", cost = " + product2.getCost());

        Product product3 = new Product(new Sausage());
        System.out.println(product3.getNameType() + ", cost = " + product3.getCost());
    }
}
