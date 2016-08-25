package FutureTask;

import java.util.concurrent.Callable;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        return String.valueOf(Thread.currentThread().getId());
    }
}
