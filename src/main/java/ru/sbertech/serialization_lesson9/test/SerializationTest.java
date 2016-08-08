package ru.sbertech.serialization_lesson9.test;


import java.io.*;

//class Person implements Serializable{
//    private String firstName;
//    private  int age;
//
//    public Person() {
//        this.firstName = "Mike";
//        this.age = 20;
//        System.out.println("person");
//    }
//
//    public Person(String firstName, int age) {
//        this.firstName = firstName;
//        this.age = age;
//    }
//}

class Student implements Serializable{
    private String group;
    private int avgMark;
    private String secureData;

    final static  long serialVersionUID = 0L;
    //private transient String password; // выключение сериализации

    public Student(){
        group = "default";
        avgMark = 3;
        //password = "my pass";
        //System.out.println("I'm in constructor");
    }
    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", avgMark=" + avgMark +
                //", password=" + password +
                '}';
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public String getSecureData() {
        return secureData;
    }

    public void setSecureData(String secureData) {
        this.secureData = secureData;
    }

    private void writeObject(ObjectOutputStream out)throws  IOException{
        // throw new NotSerializableException() - запре сериализации Student'a - потомка Person
        avgMark = avgMark ^ 0xFFFFFFFF;
        out.defaultWriteObject();
        out.writeLong(System.currentTimeMillis());
    }

    private void readObject(ObjectInputStream in)throws  IOException, ClassNotFoundException{
        in.defaultReadObject();
        avgMark = avgMark ^ 0xFFFFFFFF;
        long value = in.readLong();
        System.out.println(value);
    }
}

public class SerializationTest{

    public static void main(String[] args)throws Exception{

        String fileName = "student.bin";

//        Student student = new Student();
//        System.out.println(student);
//        try (FileOutputStream fis = new FileOutputStream(fileName);
//        ObjectOutputStream oos = new ObjectOutputStream(fis)){
//            oos.writeObject(student);
//        }

        Student student1;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)){
             student1 = (Student) ois.readObject();
            // при десиарилизации конструктор сериализуемого класса не вызвается
        }
        System.out.println(student1);
    }
}
