package ru.sbertech.serialization_lesson9.test;

import java.io.*;

class A implements Serializable{

    private B b;

    public B getB() {
        return b;
    }
    public void setB(B b) {
        this.b = b;
    }
}

class C implements Serializable{
    private A a;

    public A getA() {
        return a;
    }
    public void setA(A a) {
        this.a = a;
    }
}

class B implements Serializable{
    private C c;

    public C getC() {
        return c;
    }
    public void setC(C c) {
        this.c = c;
    }
}

public class RecursiveLinks {
    public static void main(String[] args)throws Exception {
        String fileName = "links.bin";
        A a = new A();
        B b = new B();
        C c = new C();
        a.setB(b);
        b.setC(c);
        c.setA(a);

        try (FileOutputStream fis = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(a);
            oos.writeObject(b);
            oos.writeObject(c);
        }

        A a1;
        B b1;
        C c1;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            a1 = (A) ois.readObject();
            b1 = (B) ois.readObject();
            c1 = (C) ois.readObject();
        }
        System.out.println(a == a1);
        System.out.println(b == b1);
        System.out.println(c == c1);

        System.out.println(a.getB() == b1);
        System.out.println(b.getC() == c1);
        System.out.println(c.getA() == a1);
    }
}

