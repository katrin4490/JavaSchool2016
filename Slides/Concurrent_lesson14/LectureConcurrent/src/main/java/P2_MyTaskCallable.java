import java.util.concurrent.Callable;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P2_MyTaskCallable implements Callable<Long> {
    public Long call() throws Exception {
        return Thread.currentThread().getId();
    }
}
