package ru.sbertech.homework.comparator;

import java.util.Comparator;

/**
 * Created by программист on 19.07.2016.
 */
public class StringLenghtComparator implements Comparator<String> {
    public int compare(String a, String b){

        if(a.length()> b.length())
            return 1;
        else if(a.length()< b.length())
            return -1;
        else
            return 0;
    }
}
