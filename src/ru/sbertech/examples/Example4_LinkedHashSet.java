package ru.sbertech.examples;

import ru.sbertech.collections_api_lesson3.Person;
import ru.sbertech.collections_api_lesson3.PersonFirstLoad;

import java.util.Set;
import java.util.LinkedHashSet ;

/**
 * Created by Student on 18.07.2016.
 */
public class Example4_LinkedHashSet {

    public static void main (String[] args) {
        Set<Person> persons = new LinkedHashSet <>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println("size=" + persons.size());

    }

}