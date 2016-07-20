package ru.sbertech.homework.examples;

import ru.sbertech.homework.comparator.StringLenghtComparator;
import ru.sbertech.homework.comparator.StringNameComparator;
import ru.sbertech.homework.initial.StringArrayInit;

import java.io.*;
import java.util.*;

/**
 * Created by программист on 19.07.2016.
 */
public class Sort_TreeSet {
    public static void main (String[] args) throws IOException {
        Comparator<String> comp = new StringLenghtComparator().thenComparing(new StringNameComparator());
        Set<String> strings2 = new TreeSet(comp);
        StringArrayInit.init(strings2);
        strings2.forEach(System.out::println);
    }
}
