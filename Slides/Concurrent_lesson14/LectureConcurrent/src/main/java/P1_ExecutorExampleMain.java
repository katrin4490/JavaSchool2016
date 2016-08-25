import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P1_ExecutorExampleMain {

    public static void main(String[] args) {
//        Executor executor = new Executor() {
//            public void execute(Runnable command) {
//                command.run();
//            }
//        };

        Executor executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            System.out.println(i + " Boss thread = " + Thread.currentThread().getId());
            executor.execute(new P1_MyTask(i));
        }
        ((ExecutorService)executor).shutdown();

    }
}
