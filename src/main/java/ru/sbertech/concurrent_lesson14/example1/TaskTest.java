package ru.sbertech.concurrent_lesson14.example1;

import ru.sbertech.concurrent_lesson14.example1.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskTest {
    public static void main(String[] args) {
        //throws Exception {
            Runnable task = new Task();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            System.out.println("Id Main Thread = " + Thread.currentThread().getId());
            executorService.submit(task);
            executorService.shutdown();
       // }
    }
}

