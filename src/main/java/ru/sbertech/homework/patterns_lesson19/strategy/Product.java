package ru.sbertech.homework.patterns_lesson19.strategy;


public class Product {
    private final ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public int getCost() {
        return this.productType.getCost();
    }

    public String getNameType(){
        return this.productType.getClass().getSimpleName();
    }
}
