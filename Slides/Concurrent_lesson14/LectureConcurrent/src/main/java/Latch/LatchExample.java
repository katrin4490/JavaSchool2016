package Latch;

import static Latch.P4_Main.endGate;
import static Latch.P4_Main.startGate;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class LatchExample implements Runnable {
    public void run() {
        try {
            System.out.println("before startGate.await()");
            startGate.await();
            System.out.println("after startGate.await()");
            try {
                System.out.println("Текущее состояние endGate.getCount(): "+ endGate.getCount());
            } finally {
                endGate.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
