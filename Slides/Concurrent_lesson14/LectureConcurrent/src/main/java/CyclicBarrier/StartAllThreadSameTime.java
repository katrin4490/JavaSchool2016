package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;


import static CyclicBarrier.P5_Main.barrier;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class StartAllThreadSameTime implements Runnable {

    public void run() {

        try {
            System.out.println("Phase 1");
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Phase 2");
            barrier.await();
            System.out.println("Phase 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

