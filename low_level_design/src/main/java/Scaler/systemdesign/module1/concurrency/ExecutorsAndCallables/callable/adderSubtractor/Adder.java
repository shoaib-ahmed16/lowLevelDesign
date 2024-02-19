package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.adderSubtractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    private final Count count;
    private final Lock lock;

    @Override
    public void run() {
        for(int index =0;index<1000;index++){
//            lock.lock();  // Critical Section start
//            synchronized (count) {
                count.incrementCount(index);
//            }
//            lock.unlock();  // Critical Section end
        }
    }
    public Adder(Count count,Lock lock){
        this.count=count;
        this.lock=lock;
    }
}
