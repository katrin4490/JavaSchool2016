package Semafore;

/**
 * Created by sbt-raspopov-om on 25/08/2016.
 */
public class AddToSet implements Runnable {
    private Integer i;
    private BoundedHashSet set;

    public AddToSet(Integer i, BoundedHashSet set) {
        this.i = i;
        this.set = set;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getId()+" Попытка добавить "+ i);
            set.add(i);
            System.out.println(Thread.currentThread().getId()+" Успешно добавили "+ i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
