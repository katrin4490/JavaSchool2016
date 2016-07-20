package ru.sbertech.homework.comparator;

import java.util.Comparator;

/**
 * Created by программист on 19.07.2016.
 */
public class StringNameComparator implements Comparator<String> {

    public int compare(String a, String b){

        return a.compareTo(b);
    }
}