package ru.sbertech.reflection_lesson6;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

       // Arrays.asList(B.class.getMethods()).forEach(System.out::println);
       // Arrays.asList(C.class.getDeclaredMethods()).forEach(System.out::println);
        try  {
            Field f = C.class.getDeclaredField("str");
            f.setAccessible(true);
            C c = new C();

            f.set(c , "second");
            System.out.println(f.get(c));

            c.someMethod("test");
            //Method m = I.class.getMethod("someMethod", String.class);
            //m.setAccessible(true);
            //m.invoke(C.class.newInstance(), "test");
             //System.out.println(Object.class.getSuperclass());
            //System.out.println(C.class.getField("aB"));
        } catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
