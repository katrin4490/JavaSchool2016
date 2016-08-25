import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P3_Main {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        executorService.scheduleAtFixedRate(new P1_MyTask(1), 0, 2, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
