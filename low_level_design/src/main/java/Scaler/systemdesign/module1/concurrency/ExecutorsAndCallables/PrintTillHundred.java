package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintTillHundred {
    // Requirement : To print numbers from 1 to 100, each from a separate Thread.

    // Approach:
    // 1. Think what all types of tasks do you want to do in parallel.
    public static void main(String[] args) {

        // Normally assigning the New task to new thread waste of resource due to context switching
        for(int i =0;i<100;i++){
            Thread thread = new Thread(new NumberPrinter(i));
            thread.setName(" No: "+i);
             thread.start();
        }

        // Thread Pool :
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0;i<1000;i++){
            if(i==50){
                System.out.println("Wait");
            }
            executorService.submit(new NumberPrinter(i));
        }
        executorService.shutdown();


    }
}
