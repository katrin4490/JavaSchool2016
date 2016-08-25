package ru.sbertech.homework.jmm_lesson13.task2;

import java.util.concurrent.Future;

public class MyRunCallback implements Runnable {
    private Future[] futures;
    private Runnable callback;

    public MyRunCallback(Future[] futures, Runnable callback) {
        this.futures = futures;
        this.callback = callback;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.futures.length; i++) {
            try {
                this.futures[i].get();
            } catch (Exception e) { }
        }
        this.callback.run();
    }
}

