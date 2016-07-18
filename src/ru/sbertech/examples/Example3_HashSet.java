package ru.sbertech.examples;

import ru.sbertech.collections_api_lesson3.Person;
import ru.sbertech.collections_api_lesson3.PersonFirstLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Student on 18.07.2016.
 */
public class Example3_HashSet {

    public static void main (String[] args) {
        Set<Person> persons = new HashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println("size=" + persons.size());

    }

}
