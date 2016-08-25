package ru.sbertech.concurrent_lesson14.example2_scheduled;

/**
 * Created by Student on 25.08.2016.
 */
public class Reminder implements Runnable {
    @Override
    public void run() {
        System.out.println("From run " + Thread.currentThread().getId());
    }
}
