package ru.sbertech.class_loader_lesson7;


import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main (String[] args) throws Exception {

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {new URL ("file:/J:/lecture7/person.jar")});

        Class<?> calcClazz = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.CalculatorImpl");
        ((Calculator)calcClazz.newInstance()).calc();

        Calculator calculator = new CalculatorImpl();
        calculator.calc();













        /////////////////////////////////////////////////////////////////////////
        //URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {new URL ("file:/J:/lecture7/person.jar")}, null);
        //Class<?> persClazz = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.Person");

        //Object o = persClazz.newInstance();
        //Method m = persClazz.getMethod("info");
        //m.invoke(o);









/////////////////////////////////////////////////////////////////////

//        for (int i=0; i<1000000; i++){
//            new URLClassLoader(new URL[] {new URL ("file:/J:/lecture7/person.jar")}, null).loadClass("ru.sbt.bvv.lecture7.Person");
//        }
//////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////
//        System.out.println("1");
//        try {
//            Person person = (Person) Main.class.getClassLoader().loadClass("ru.sbertech.class_loader_lesson7.Person").newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("2");
    }
}
