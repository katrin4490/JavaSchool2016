package Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class P4_Main {
    private final static int nThreads = 5;
    public final static CountDownLatch startGate = new CountDownLatch(1);
    public final static CountDownLatch endGate = new CountDownLatch(nThreads);

    public static void waitEnd() throws InterruptedException {
        System.out.println("Поставили поток в ожидание... endGate.await()");
        endGate.await();
        System.out.println("Дождались конца");

    }

    public static void main(String[] args) throws InterruptedException {

            ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.execute(new LatchExample());
            System.out.println("Отдали executor - у задачу");
            System.out.println(".........");
            System.out.println(".........");
            System.out.println(".........");
            System.out.println(".........");
            startGate.countDown();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        waitEnd();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            for (int i = 0; i < 5; i++) {
                executorService.execute(new LatchExample());
            }
        } finally {
            executorService.shutdown();
        }


    }



}
