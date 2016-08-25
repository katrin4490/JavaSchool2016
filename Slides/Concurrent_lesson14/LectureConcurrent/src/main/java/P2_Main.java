import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P2_Main {
    public static void main(String[] args) {
        Collection<Future<Long>> res = new ArrayList<Future<Long>>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            Future<Long> fut = executorService.submit(new P2_MyTaskCallable());
            res.add(fut);
        }

        executorService.shutdown();

    }
}
