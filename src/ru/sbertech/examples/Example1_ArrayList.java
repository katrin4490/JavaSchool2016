package ru.sbertech.examples;

import ru.sbertech.collections_api_lesson3.Person;
import ru.sbertech.collections_api_lesson3.PersonFirstLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 18.07.2016.
 */
public class Example1_ArrayList {

    public static void main (String[] args) {
        List<Person> persons = new ArrayList<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        //System.out.println(persons.get(10));
        System.out.println("---------------------------------");

        PersonFirstLoad.print(persons.subList(10,15));

        Person p = new Person(10L, "fio", "79185551224");

        System.out.println(persons.contains(p));

    }

}
