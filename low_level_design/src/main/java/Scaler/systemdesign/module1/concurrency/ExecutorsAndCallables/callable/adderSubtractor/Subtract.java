package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.adderSubtractor;

import java.util.concurrent.locks.Lock;

public class Subtract implements Runnable{
    private  Count count;
    private Lock lock;
    @Override
    public void run() {
        for(int index =0;index<1000;index++){
            lock.lock(); // Critical Section start
            int value=count.getValue();
            value=value-index;
            count.setValue(value);
            lock.unlock();  // Critical Section end
        }
    }
    public Subtract(Count count,Lock lock){
        this.count=count;
        this.lock=lock;
    }
}
