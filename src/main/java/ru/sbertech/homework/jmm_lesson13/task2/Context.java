package ru.sbertech.homework.jmm_lesson13.task2;

public interface Context {
    int getCompletedTaskCount();

    int getFailedTaskCount();

    void interrupt();

    int getInterruptedTaskCount();

    boolean isFinished();
}

