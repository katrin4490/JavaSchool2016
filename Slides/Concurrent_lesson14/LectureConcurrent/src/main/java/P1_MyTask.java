/**
 * Created by sbt-raspopov-om on 24/08/2016.
 */
public class P1_MyTask implements Runnable{
    private int id;
    public void run() {
        System.out.println(id + " Worker's thread = " + Thread.currentThread().getId());
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public P1_MyTask(int id) {
        this.id = id;
    }
}