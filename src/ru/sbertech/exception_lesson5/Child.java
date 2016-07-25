package ru.sbertech.exception_lesson5;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class Parent{

    public  void method() throws IOException {

    }
}



public class Child extends Parent {

    @Override
    public  void method() throws  IOException {

    }

    public void test(Parent a)throws IOException {
        a.method();
    }

    public static void main(String[] args)throws  IOException {
        Parent a = new Child();
        Child b = new Child();

        Child ch = new Child();
        ch.test(a);
        ch.test(b);
    }
}












/*

    public static void main(String[] args) throws IOException {
        f();

        try{

            f();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
    private static void f() throws IOException {
        g();
    }
    private static void g() throws IOException {
        FileInputStream in = new FileInputStream("1.txt");

        in.close();
    }
    */