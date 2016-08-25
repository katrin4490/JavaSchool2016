package ru.sbertech.homework.jmm_lesson13.task2;

import java.util.concurrent.Future;

public class ContextImpl implements Context{
    private Future[] futures;
    private MyRun[] myRuns;

    public ContextImpl(Future[] futures, MyRun[] myRuns) {
        this.futures = futures;
        this.myRuns = myRuns;
    }

    @Override
    public int getCompletedTaskCount() {
        int completed = 0;
        for (int i = 0; i < this.futures.length; i++) {
            if (this.futures[i].isDone() && !this.myRuns[i].isCancel()){
                try {
                    this.futures[i].get();
                    completed++;
                } catch (Exception e) { }
            }
        }
        return completed;
    }

    @Override
    public int getFailedTaskCount() {
        int failed = 0;
        for (int i = 0; i < this.futures.length; i++) {
            if (this.futures[i].isDone()){
                try {
                    this.futures[i].get();
                } catch (Exception e) {
                    failed++;
                }
            }
        }
        return failed;
    }

    @Override
    public void interrupt() {
        for (int i = 0; i < this.myRuns.length; i++) {
            this.myRuns[i].cancel();
        }
    }

    @Override
    public int getInterruptedTaskCount() {
        int interrupted = 0;
        for (int i = 0; i < myRuns.length; i++) {
            if (myRuns[i].isCancel()) {
                interrupted++;
            }
        }
        return interrupted;
    }

    @Override
    public boolean isFinished() {
        for (int i = 0; i < this.futures.length; i++) {
            if (!this.futures[i].isDone()) {
                return false;
            }
        }
        return true;
    }
}
