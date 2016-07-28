package ru.sbertech.reflection_lesson6;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 28.07.2016.
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> loggedList = (List<String>) Proxy.newProxyInstance(
                list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                new InvocationHandlerImpl(list));
        loggedList.add("first");
        System.out.println(loggedList.get(0));
        System.out.println(loggedList.remove(0));
        System.out.println(loggedList.size());
    }
}
