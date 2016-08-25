package ru.sbertech.homework.jmm_lesson13.task2;

public class MyRun implements Runnable {
    Runnable runnable;
    boolean cancel = false;
    boolean finish = false;

    public MyRun(Runnable runnable){
        this.runnable = runnable;
    }

    public boolean isCancel(){
        return this.cancel;
    }

    public void cancel(){
        if (!this.finish) {
            this.cancel = true;
        }
    }

    @Override
    public void run() {
        if (!this.cancel) {
            this.runnable.run();
            this.finish = true;
        }
    }
}
