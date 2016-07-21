package ru.sbertech.homework.initial;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by программист on 21.07.2016.
 */
public class StringArray implements Iterable<String> {

    private List<String> strings;
    private int currentSize;

    public StringArray(List<String> newStrings) {
        this.strings = newStrings;
        this.currentSize = newStrings.size();
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex > -1;
            }

            @Override
            public String next() {
                return strings.get(currentIndex--);
            }

        };
        return it;
    }
}
