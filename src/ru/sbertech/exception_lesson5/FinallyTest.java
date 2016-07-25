package ru.sbertech.exception_lesson5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Student on 25.07.2016.
 */
public class FinallyTest {
    public static void main (String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("c:\\1.txt");
            out = new FileOutputStream("c:\\2.txt");
            out.write(in.read());
        } catch (IOException e){
            System.out.println("File not found");
        } finally {
            try {
                if (in != null){
                    in.close();
                }
            } catch (IOException e){
                // NOP
            }
            try {
                if (in != null) {
                    out.close();
                }
            } catch (IOException e){
                // NOP
            }
        }





  ///////////////////////////////////////////
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("I'm not thread");
                }
            }
        }).start();
        int a = 6/0;


////////////////////////////////////
        //System.out.println(f());
        */
    }

    private static int f() {
        try {
            //return 1;
            throw new Exception();
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }
    }
}
