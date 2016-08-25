package FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P4_Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        MyFutureRunnable futureTask = new MyFutureRunnable(new MyCallable());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask);
//        Thread.sleep(1000L);
        if (!futureTask.isDone()){
            System.out.println(futureTask.get());
        }
        executorService.shutdown();
    }
}
