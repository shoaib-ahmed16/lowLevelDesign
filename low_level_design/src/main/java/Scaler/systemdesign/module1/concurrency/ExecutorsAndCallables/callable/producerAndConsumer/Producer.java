package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    @Override
    public void run() {
        while (true){
            try {
                forProducer.acquire();
                buffer.add(new UnitOfWork());
                forConsumer.release();
                System.out.println(this.name + " produced food. Existing buffer Size:" + this.buffer.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Producer(String name,Queue<UnitOfWork> buffer,Semaphore forProducer,Semaphore forConsumer){
        this.name=name;
        this.buffer=buffer;
        this.forProducer=forProducer;
        this.forConsumer=forConsumer;
    }
}
