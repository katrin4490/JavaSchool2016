package ru.sbertech.collections_api_lesson3.BeforeGeneric;

/**
 * Created by Student on 18.07.2016.
 */
public class Apple {

    final Long id = counter++;
    static Long counter = new Long(0L);

    public Long getId() {
        return id;
    }

}
