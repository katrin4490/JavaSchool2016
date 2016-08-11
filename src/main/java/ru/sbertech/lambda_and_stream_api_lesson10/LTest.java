package ru.sbertech.lambda_and_stream_api_lesson10;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LTest {
    public static void main(String[] args) {
        //Predicate<Apple> p = (o1) -> o1.getSize().intValue() > 10;
        //BiPredicate<Apple, Apple> biP = (o1, o2) -> o1.getSize().equals(o1.getSize());

        //Comparator.comparing(Apple::getSize).reversed().thenComparing(Apple::getSize);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

}
