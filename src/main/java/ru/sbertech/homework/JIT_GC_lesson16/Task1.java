package ru.sbertech.homework.JIT_GC_lesson16;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        int size = 100_000;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(i, CreateValue(i));
        }
    }

    public static String CreateValue(int i) {
        return "value: " + i;
    }
}
