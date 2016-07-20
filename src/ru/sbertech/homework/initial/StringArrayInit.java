package ru.sbertech.homework.initial;

import ru.sbertech.collections_api_lesson3.Person;

import java.util.*;

/**
 * Created by программист on 19.07.2016.
 */
public class StringArrayInit {
    public static Collection<String> init(Collection<String> strings) {
        strings.add("компьютер");
        strings.add("телевизор");
        strings.add("дело");
        strings.add("учеба");
        strings.add("номер");
        strings.add("комп");
        strings.add("россия");
        strings.add("линейка");
        strings.add("работа");
        strings.add("ручка");
        strings.add("компьютер");
        strings.add("машина");
        strings.add("дело");
        strings.add("учеба");
        strings.add("номер");
        strings.add("автомобиль");
        strings.add("страна");
        strings.add("правда");
        strings.add("свадьба");
        strings.add("учеба");
        return strings;
    }

    public static Map<String, Integer> init(Map<String, Integer> strings) {
        List<String> stringList = new ArrayList<>();
        init(stringList);
        Integer ii;
        for (String s : stringList) {
            ii = strings.get(s);
            strings.put(s, ii == null ? 1 : ii + 1);
        }
        return strings;
    }

    public static void print(Map<String, Integer> strings) {

        Iterator it = strings.entrySet().iterator();

        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
