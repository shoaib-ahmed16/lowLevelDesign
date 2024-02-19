package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;

    private Lock lock;
    @Override
    public void run() {
        while (true){
            // Critical Section starts
//            synchronized (buffer) {
                lock.lock();
                if (! buffer.isEmpty()) {
                    buffer.remove();
                    // Critical Section ends
                    System.out.println(this.name + " consumed food. Existing buffer size:" + this.buffer.size());
                }
                 lock.unlock();
//            }
        }
    }
    public Consumer(String name,Queue<UnitOfWork> buffer,Lock lock){
        this.name=name;
        this.buffer=buffer;
        this.lock=lock;
    }
}
