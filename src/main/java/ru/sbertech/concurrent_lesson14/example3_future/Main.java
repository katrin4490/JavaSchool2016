package ru.sbertech.concurrent_lesson14.example3_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyFutureRunnable futureTask = new MyFutureRunnable(new MyCallable());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask);
        //Thread.sleep(1000L);

        if(!futureTask.isDone()){
            System.out.println(futureTask.get());
        }

        executorService.shutdown();
    }
}
