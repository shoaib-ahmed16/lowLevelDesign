package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquarePrinterMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> values= List.of(2,3,4,5,6,7);
        ExecutorService executor= Executors.newCachedThreadPool();

//       Executor use case: with Runnable Interface Implemented.
        for(Integer value:values){
            Thread thread =new Thread(new SquarePrinter(value));
            thread.start();
        }

        List<Future<Integer>> futures =new ArrayList<>();
        // Executor use case: with Callable Interface Implemented.
        for(Integer value:values){
            Future<Integer> integerFuture =executor.submit(new SquareGenerator(value));
            futures.add(integerFuture);
        }


        for(Future<Integer> future:futures){
            System.out.println(future.isDone());
        }


        Thread.sleep(1000);
        for(Future<Integer> future:futures){
            System.out.println("The Square is :"+future.get());
        }
    }
}
