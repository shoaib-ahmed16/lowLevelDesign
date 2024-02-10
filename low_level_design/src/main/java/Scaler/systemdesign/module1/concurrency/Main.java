package Scaler.systemdesign.module1.concurrency;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        Thread thread1 = new Thread(new HelloWordPrinterOne());
        thread1.start();
        Thread thread2 = new Thread(new HelloWordPrinterTwo());
        thread2.start();
        System.out.println(3);
        System.out.println(4);
    }
}
