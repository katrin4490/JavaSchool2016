package ru.sbertech.homework.jmm_lesson13.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        Task<Integer> task = new Task<>(callable);
        List<Integer> results = new ArrayList<>();

        int countThread = 10;
        Thread[] threads = new Thread[countThread];

        for (int i = 0; i < countThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        results.add(task.get());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("result " + (i + 1) + ":   " + results.get(i));
        }
    }
}
