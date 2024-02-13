package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergerSortRunnerMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> values= new ArrayList<>(Arrays.asList(10,9,8,7,1,2,3,4,5,4,15,24,34,60,71,12,22,31,4,5,1,43,34,23,35,67,3453,2342,342,34,125,1351234,1235,1235,23512,34,12,512,35,12,35,12,35,123,5,1235,12351,35,13));
        ExecutorService executor= Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(values,executor);
        Future<List<Integer>> sortedValues=executor.submit(sorter);
        System.out.println(sortedValues.get());

     }
}
