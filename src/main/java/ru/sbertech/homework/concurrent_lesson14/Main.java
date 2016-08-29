package ru.sbertech.homework.concurrent_lesson14;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Calc c = new Calculator();
        c = ConcurrentCachedProxy.create(Calc.class, c);
//      ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newCachedThreadPool();

        int count = 25;
        Future<Integer>[] futures = new Future[count];
        int number1;
        int number2;
        try {
//            for (int i = 0; i < count; i++) {
//                number1 = i;
//                number2 = i;
//                if (i > (count - 5)) {
//                    number1 = i - 5;
//                    number2 = i - 5;
//                }
//                futures[i] = executorService.submit(new CalculatorCallable(c, number1, number2));
//            }
            for (int i = 0; i < count; i++) {
                number1 = number2 = new Random().nextInt(15);
//                number2 = new Random().nextInt(15);
                futures[i] = executorService.submit(new CalculatorCallable(c, number1, number2));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(1200);
//        System.out.println("-------------------");
//        for(int i = 0; i < count; i++){
//            System.out.println((i+1) + ": " + futures[i].get());
//        }

        executorService.shutdown();
        System.out.println("End of Main");
    }
}
