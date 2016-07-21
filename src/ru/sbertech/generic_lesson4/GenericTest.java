package ru.sbertech.generic_lesson4;

import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * Created by Student on 21.07.2016.
 */
public class GenericTest {
    public static void main(String[] args){

        // extend
        A <? extends  B>  a= new A(new B());
        A aa = a.getParam();
        B b = a.getParam();
        // C c = a.getParam(); - нельзя - т.к. C не вяляется потомком В
        System.out.println(a.getType());

        /*
          A<? extends Integer> a = new A<>();
        //a.setParam(new Integer(10)); - нельзя

        // а так можно - через конструктор:
        A<? extends Integer> a2 = new A<>(new Integer(10));

        Integer i = a2.getParam();
        Number n = a2.getParam();
        System.out.println(a2.getType());
        */

        //super - используется только для записи/добавления объекта, без гарантии какой тип можно считать
        List<? super Number> list = new ArrayList<>();
        list.add(new Integer(10));
        list.add(new Double(11));
        list.add(new Integer(12));
        list.add(new Double(13));
        list.forEach(System.out::println);
        //Number i = list.get(0); - ошибка
        //Object i = list.get(0); - так можно

        /*
        A <List> a  = new A<>();

        a.setParam(new ArrayList<String>());
        A <String> aString = new A<>();
        aString.setParam(new String("test"));
        System.out.println(a.getType());
        System.out.println(aString.getType());

        System.out.println(B.<Short>getType(new Short("10")));
        //System.out.println(B.<>getType(new Short("10"))); - можно и так

        List<?> list2 = new ArrayList<Integer>();
        list2.add(null); // больше кроме null нечего не можем добавить
        //Integer f = list2.get(0); // получить тоже не можем

        System.out.println(
        new A<String> (new String()){
            @Override
            public String getType() {
                return "Abstract " + param.getClass().getTypeName();
            }
        }.getType());

*/


    }
}
