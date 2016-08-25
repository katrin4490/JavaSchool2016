package Semafore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class Semafore_Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<Integer> set = new BoundedHashSet<Integer>(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 5; i++) {
                executorService.execute(new AddToSet(i, set));
            }
//            set.remove(1);
            System.out.println("--------------------");

        } finally {
//            executorService.shutdown();
        }

    }
}
