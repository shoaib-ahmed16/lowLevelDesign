package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables;

public class NumberPrinter implements Runnable{
    private final int numberToPrint;
    @Override
    public void run() {
        System.out.println("Number: "+numberToPrint+" Print By Thread"+Thread.currentThread().getName());
    }
    public NumberPrinter(int num){
        this.numberToPrint=num;
    }
}
