package ru.sbertech.homework.jmm_lesson13.task2;


public class Main {
    public static void main(String[] args) {
        ExecutionManagerImpl executionManager = new ExecutionManagerImpl();

        Runnable callback = new Runnable() {
            @Override
            public void run() {
                System.out.println("CALLBACK!!!");
            }
        };

        int countTasks = 15;

        Runnable[] runnables = new Runnable[countTasks];
        for (int i = 0; i < countTasks; i++){
            final int temp = i + 1;
            runnables[i] = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Задача № " + temp);
                }
            };
        }
        Context context = executionManager.execute(callback, runnables);

        context.interrupt();

        while (!context.isFinished()){
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("На текущий момент успешно выполнились: " + context.getCompletedTaskCount() + " тасков");
        System.out.println("Количество тасков, при выполнении которых произошел Exception: " + context.getFailedTaskCount());
        System.out.println("Количество тасков, которые не были выполены из-за отмены: " + context.getInterruptedTaskCount());

        executionManager.shutdown();
    }
}
