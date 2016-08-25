package ru.sbertech.concurrent_lesson14.example3_future;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
//        return "Thread Name = " + Thread.currentThread().getName() + "; Thread Id = " + Thread.currentThread().getId();
        return Thread.currentThread().getId() + " ";
    }
}
