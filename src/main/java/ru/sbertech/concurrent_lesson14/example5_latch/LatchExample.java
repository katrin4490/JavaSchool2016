package ru.sbertech.concurrent_lesson14.example5_latch;

import static ru.sbertech.concurrent_lesson14.example5_latch.Main.endGate;
import static ru.sbertech.concurrent_lesson14.example5_latch.Main.startGate;

public class LatchExample implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("before startGate.await()");
            startGate.await();
            System.out.println("after startGate.await()");

            try {
                System.out.println("Текущее состояние endGate.getCount(): " + endGate.getCount());
            } finally {
                endGate.countDown();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
