package ru.sbertech.examples;

import ru.sbertech.collections_api_lesson3.PersonFirstLoad;
import ru.sbertech.collections_api_lesson3.Person;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by Student on 18.07.2016.
 */
public class Example2_LinkedList {

    public static void main (String[] args) {
        List<Person> persons = new LinkedList<>();
        PersonFirstLoad.init(persons);
       //PersonFirstLoad.print(persons);



        LinkedList<Person> p = new LinkedList<>();
        PersonFirstLoad.init(p);
        PersonFirstLoad.print(p);
        System.out.println("--");
        System.out.println(p.peek());
        p.removeFirst();

        System.out.println("--");
        System.out.println(p.peek());

        System.out.println("--");

        p.poll();
        PersonFirstLoad.print(p);
    }

}
