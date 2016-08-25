package ru.sbertech.homework.jmm_lesson13.task2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionManagerImpl implements ExecutionManager {
    private ExecutorService executorService;

    public ExecutionManagerImpl(){
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void shutdown(){
        this.executorService.shutdown();
    }

    @Override
    public Context execute(Runnable callback, Runnable[] tasks) {
        int countTask = tasks.length;
        Future[] futures = new Future[countTask];
        MyRun[] myRuns = new MyRun[countTask];

        for (int i = 0; i < countTask; i++) {
            myRuns[i] = new MyRun(tasks[i]);
            futures[i] = this.executorService.submit(myRuns[i]);
            //myRuns[0].cancel();
        }
        Context context = new ContextImpl(futures, myRuns);
        new Thread(new MyRunCallback(futures, callback)).start();
        return context;
    }
}
