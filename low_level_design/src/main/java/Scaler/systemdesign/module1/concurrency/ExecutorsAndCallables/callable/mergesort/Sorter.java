package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private  List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;
    @Override
    public List<Integer> call() throws Exception {
        if(values.size()<=1){
            return values;
        }
        int mid =values.size() /2;
        List<Integer> leftArray = values.subList(0,mid);
        List<Integer> rightArray = values.subList(mid,values.size());

        Sorter  leftSorter = new Sorter(leftArray,executorService);
        Sorter rightSorter = new Sorter(rightArray,executorService);

        Future<List<Integer>> leftFuture =executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture=executorService.submit(rightSorter);
        return merge(leftFuture,rightFuture);
    }
    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture) throws ExecutionException, InterruptedException {
        List<Integer> sortedArray= new ArrayList<>();
        int first=0;
        int second =0;
        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight=sortedRightFuture.get();
        System.out.println(sortedLeft +" : "+sortedRight+" Sorting By "+Thread.currentThread().getName());
        while (first<sortedLeft.size() && second <sortedRight.size()){
            int leftArrayValue =sortedLeft.get(first);
            int rightArrayValue =sortedRight.get(second);
            if(leftArrayValue<rightArrayValue){
                sortedArray.add(leftArrayValue);
                first++;
            }else{
                sortedArray.add(rightArrayValue);
                second++;
            }
        }
        while(first<sortedLeft.size()){
            sortedArray.add(sortedLeft.get(first++));
        }
        while(second<sortedRight.size()){
            sortedArray.add(sortedRight.get(second++));
        }
        return sortedArray;
    }
    public Sorter(List<Integer> arr,ExecutorService executorService){
        this.values=arr;
        this.executorService=executorService;
    }
}
