package ru.sbertech.serialization_lesson9.test;

import java.io.*;

class DataHolder implements Serializable{
    String value = "AAAAAAAAAA";

}
public class CacheTest {
    public  static void main (String[] args) throws IOException, ClassNotFoundException {

        String fileName = "cache.bin";
        DataHolder data = new DataHolder();

        System.out.println(data);
        try (FileOutputStream fis = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fis)){
            oos.writeObject(data);
            data.value = "BBBBBB";
            oos.reset();
            //oos.writeUnshared(data);
            oos.writeObject(data);
            data.value = "CCCCCC";
            oos.reset();
           // oos.writeUnshared(data);
            oos.writeObject(data);
        }

        DataHolder data1;
        DataHolder data2;
        DataHolder data3;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            data1 = (DataHolder) ois.readObject();
            data2 = (DataHolder) ois.readObject();
            data3 = (DataHolder) ois.readObject();
        }
        System.out.println(data1 == data2);
        System.out.println(data2 == data3);
    }
}
