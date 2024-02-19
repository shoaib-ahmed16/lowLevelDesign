package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.adderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountRunner {
    public static void main(String[] args) {
        Count count= new Count();
        Lock lock = new ReentrantLock(); //ProcessLock
        Adder adder = new Adder(count,lock);
        Subtract subtract = new Subtract(count,lock);
        ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(adder);
            executor.execute(subtract);
         try {
             executor.awaitTermination(1, TimeUnit.SECONDS);
             System.out.println("Final Value: " + count.getValue());
             executor.shutdown();
         }catch (Exception exc){
             System.out.println(exc.getMessage());
         }
    }
}
