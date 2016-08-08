package ru.sbertech.generic_lesson4;

/**
 * Created by Student on 21.07.2016.
 */
public class MyThowrable<T, K> extends A {

}
/*
 public class MyThowrable<T> extends Throwabl - так нельзя!
Нельзя параметризировать : анононимные классы, enum, Throwable
new B<T>() { }; - анономный клас - нельзя параметризовать
*/