package ru.sbertech.multithread_lesson11;


public class SomeTask implements Runnable {
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++){
            System.out.println("st:" + Thread.currentThread().getName() + "(" + i + ")");
        }
    }

    public static void main(String[] args) {
        SomeTask st = new SomeTask();

        Thread t = new Thread(st);
        t.start();
        System.out.println(t.isAlive());

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isAlive());
//        for (int i = 0; i < 4; i++) {
//            new Thread(st).start();
//        }


        //st.run();

        System.out.println("End of main programm");
    }

}
