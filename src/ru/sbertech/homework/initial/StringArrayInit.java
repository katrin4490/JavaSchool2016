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

    public static TreeMap<String, Integer> init(TreeMap<String, Integer> strings) {
        List<String> stringList = new ArrayList<>();
        init(stringList);
        Integer ii;
        for (String s : stringList) {
            ii = strings.get(s);
            strings.put(s, ii == null ? 1 : ii + 1);
        }
        return strings;
    }

    public static Map<Integer, String> init(Map<Integer, String> strings) {
        int key = 1;
        strings.put(key++, "компьютер");
        strings.put(key++, "телевизор");
        strings.put(key++, "дело");
        strings.put(key++, "учеба");
        strings.put(key++, "номер");
        strings.put(key++, "комп");
        strings.put(key++, "россия");
        strings.put(key++, "линейка");
        strings.put(key++, "работа");
        strings.put(key++,  "ручка");
        strings.put(key++,  "компьютер");
        strings.put(key++,  "машина");
        strings.put(key++,  "дело");
        strings.put(key++,  "учеба");
        strings.put(key++,  "номер");
        strings.put(key++,  "автомобиль");
        strings.put(key++,  "страна");
        strings.put(key++,  "правда");
        strings.put(key++,  "свадьба");
        strings.put(key,  "учеба");
        return strings;
    }

    public static void print(Map<String, Integer> strings) {

        Iterator it = strings.entrySet().iterator();

        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    public static void printByNumber(Map<Integer, String> strings, int[] num) {

        for (int i=0; i<num.length; i++) {
            System.out.println(strings.get(num[i]));
        }
    }
}
