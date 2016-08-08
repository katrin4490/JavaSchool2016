package ru.sbertech.homework.generics;

import java.util.*;


public class MyListArray<T> {
    private List<T> elements = new ArrayList<T>();

    public boolean add(T element) {
        return elements.add(element);
    }
    public void add(int index, T element) {
        elements.add(index, element);
    }
    public T get(int index) {
        return elements.get(index);
    }
    public T remove(int index) {
        return elements.remove(index);
    }
    public boolean remove(Object o) {
        return elements.remove(o);
    }
    public boolean addAll(Collection<? extends T> c) {
        return elements.addAll(c);
    }
    public boolean addAll(int index, Collection<? extends T> c) {
        return elements.addAll(index, c);
    }
    public boolean copy(List<? super T> dest) {
        return dest.addAll(elements);
    }
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public void Print() {
        elements.forEach(System.out::println);
    }
}
