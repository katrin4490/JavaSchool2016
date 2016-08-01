package ru.sbertech.homework.reflection_lesson6;

import com.sun.deploy.security.ValidationState;
import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by программист on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Все String константы, которые имеют значение = их имени:");
            A a = new A();
            Field[] f = A.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                f[i].setAccessible(true);
                if (f[i].getGenericType() == String.class &&
                        Modifier.isFinal(f[i].getModifiers()) &&
                        f[i].getName() == f[i].get(a).toString()) {
                    System.out.println("Имя: " + f[i].getName() + "  значение: " + f[i].get(a).toString());
                }
            }
            System.out.println("");
            System.out.println("Все геттеры класса:");
            Method[] m = Object.class.getDeclaredMethods();
            String s;
            for (int i=0; i<m.length; i++){
                if (!m[i].getReturnType().equals(Void.TYPE)) {
                    System.out.println("Метод: " + m[i].getName() + "  возвращаемое значение: " + m[i].getReturnType().getName());
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
