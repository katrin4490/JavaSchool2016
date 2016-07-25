package ru.sbertech.homework.generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by программист on 25.07.2016.
 */
public class Main {
    public static void main (String[] args) throws IOException {
        MyListArray<Number> list = new MyListArray<>();
        list.add(new Integer(6));
        list.add(new Integer(2));
        list.add(new Integer(0));
        list.add(new Float(5.5));
        list.add(0, new Float(5.5));

        List<Float> list2 = new ArrayList<>();
        list2.add(new Float(4.5));

        list.addAll(list2);
        list.Print();

        System.out.println("\n" + list.get(0).toString());

        list.remove(1);
        System.out.println("\nПосле удаления:");
        list.Print();

        System.out.println("\nСкопированный лист:");
        List<Object> list3 = new ArrayList<>();
        list.copy(list3);
        list3.forEach(System.out::println);
    }
}
