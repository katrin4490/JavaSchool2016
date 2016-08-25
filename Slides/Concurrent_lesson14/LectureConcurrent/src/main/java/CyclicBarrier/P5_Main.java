package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class P5_Main {
    public final static CyclicBarrier barrier = new CyclicBarrier(10);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 9; i++) {
            executorService.execute(new StartAllThreadSameTime());
        }
        Thread.sleep(2000L);
        System.out.println("--------------------------");

    }
}
