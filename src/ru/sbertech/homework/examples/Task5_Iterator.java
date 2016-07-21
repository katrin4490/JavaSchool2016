package ru.sbertech.homework.examples;

import ru.sbertech.homework.initial.StringArray;
import ru.sbertech.homework.initial.StringArrayInit;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by программист on 21.07.2016.
 */
public class Task5_Iterator {
    public static void main(String[] args){

        ArrayList<String> strings = new ArrayList<String>();
        StringArrayInit.init(strings);
        StringArray sa = new StringArray(strings);
        Iterator<String> is = sa.iterator();
        while(is.hasNext()) {
            System.out.println(is.next().toString());
        }
    }
}
