package ru.sbertech.homework.examples;

import ru.sbertech.homework.comparator.StringLenghtComparator;
import ru.sbertech.homework.comparator.StringNameComparator;
import ru.sbertech.homework.initial.StringArray;
import ru.sbertech.homework.initial.StringArrayInit;

import java.util.*;


/**
 * Created by программист on 19.07.2016.
 */
public class Task_1_2_3 {
    public static void main(String[] args) {

        Comparator<String> comp = new StringLenghtComparator().thenComparing(new StringNameComparator());
        TreeMap<String, Integer> strings = new TreeMap(comp);
        StringArrayInit.init(strings);
        StringArrayInit.print(strings);
    }
}