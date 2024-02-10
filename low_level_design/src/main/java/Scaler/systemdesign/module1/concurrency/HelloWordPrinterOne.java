package Scaler.systemdesign.module1.concurrency;

public class HelloWordPrinterOne implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World 1");
    }
}
