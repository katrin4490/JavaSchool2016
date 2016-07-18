package ru.sbertech.examples;

import ru.sbertech.collections_api_lesson3.Person;
import ru.sbertech.collections_api_lesson3.PersonFirstLoad;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by Student on 18.07.2016.
 */
public class Example5_Map {

    public static void main (String[] args) {
        Map<String, Person> persons = new HashMap<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println("size=" + persons.size());


        System.out.println(persons.get("16"));

    }

}