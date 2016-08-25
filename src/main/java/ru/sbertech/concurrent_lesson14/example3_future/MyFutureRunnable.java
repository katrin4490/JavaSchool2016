package ru.sbertech.concurrent_lesson14.example3_future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureRunnable extends FutureTask {
    public  MyFutureRunnable (Callable callable) {super(callable);}

    @Override
    public void run() {
        super.run();
        System.out.println("Post Method");
    }
}
