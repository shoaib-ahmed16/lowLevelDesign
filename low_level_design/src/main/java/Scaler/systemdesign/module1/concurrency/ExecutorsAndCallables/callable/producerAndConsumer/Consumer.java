package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;
    @Override
    public void run() {
        while (true){
            try {
                forConsumer.acquire();
                buffer.remove();
                forProducer.release();
                System.out.println(this.name + " consumed food. Existing buffer size:" + this.buffer.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public Consumer(String name,Queue<UnitOfWork> buffer,Semaphore forProducer,Semaphore forConsumer){
        this.name=name;
        this.buffer=buffer;
        this.forProducer=forProducer;
        this.forConsumer=forConsumer;
    }
}
