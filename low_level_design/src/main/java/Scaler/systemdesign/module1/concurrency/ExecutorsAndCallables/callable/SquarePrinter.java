package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable;

public class SquarePrinter implements   Runnable{

    private final Integer number;
    @Override
    public void run() {

        System.out.println((number * number) +" Printed By "+Thread.currentThread().getName());
    }
    public SquarePrinter(int num){
        this.number=num;
    }
}
