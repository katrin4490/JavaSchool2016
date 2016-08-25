package ru.sbertech.homework.jmm_lesson13.task1;

import java.util.concurrent.Callable;

public class Task<T> {

    private volatile T t;
    private Callable<? extends T> callable;
    private RuntimeException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        if (t == null && exception == null){
            synchronized (this){
                if (t == null && exception == null){
                    try {
                        t = callable.call();
                    }
                    catch (RuntimeException e){
                        exception = e;
                    }
                    catch (Exception e){
                        exception = new RuntimeException(e);
                    }
                }
            }
        }
        if (exception != null)
            throw exception;
        return t;
    }
}

