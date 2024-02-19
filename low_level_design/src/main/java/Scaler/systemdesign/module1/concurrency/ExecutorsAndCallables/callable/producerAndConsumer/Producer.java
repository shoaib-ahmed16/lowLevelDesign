package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Integer maxSize;
    private Lock lock;
    @Override
    public void run() {
        while (true){
//            synchronized (buffer) {
                lock.lock();
                if (buffer.size() < this.maxSize) {
                    buffer.add(new UnitOfWork());
                    System.out.println(this.name + " produced food. Existing buffer Size:" + this.buffer.size());
                }
                lock.unlock();
//            }
        }
    }
    public Producer(String name,Queue<UnitOfWork> buffer,Integer size,Lock lock){
        this.name=name;
        this.buffer=buffer;
        this.maxSize=size;
        this.lock=lock;
    }
}
