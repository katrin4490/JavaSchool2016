package ru.sbertech.concurrent_lesson14.example1;


public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Id Thread = " + Thread.currentThread().getId());
    }
}
