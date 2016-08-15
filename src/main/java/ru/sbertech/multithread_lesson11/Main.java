package ru.sbertech.multithread_lesson11;


public class Main {
    public static void main(String[] args) {

        SomeTask st = new SomeTask();
        Thread t1 = new Thread(st);
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(st);
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(st);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t3.start();
        t2.start();

//        SomeThread st1 = new SomeThread();
//        st1.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I'm here now");
//            }
//        }).start();
    }
}
