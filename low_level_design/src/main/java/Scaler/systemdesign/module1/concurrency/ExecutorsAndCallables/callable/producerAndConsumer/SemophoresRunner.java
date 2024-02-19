package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

import static java.util.stream.Collectors.toSet;

public class SemophoresRunner {
    private static final Set<String> producerNames = Set.of("p1","p2","p3");
    private static final Set<String> consumerNames = Set.of("c1","c2","c3");
    public static void main(String[] args) {
        Queue<UnitOfWork> buffer=new ConcurrentLinkedDeque<>();
        int maxSize=10;
        Semaphore forProducer= new Semaphore(maxSize);
        Semaphore forConsumer= new Semaphore(0);
        Set<Producer> producers = producerNames.stream().map(name-> new Producer(name,buffer,forProducer,forConsumer)).collect(toSet());
        Set<Consumer> consumers = consumerNames.stream().map(name-> new Consumer(name,buffer,forProducer,forConsumer)).collect(toSet());
        producers.forEach(producer -> new Thread(producer).start());
        consumers.forEach(consumer -> new Thread(consumer).start());
    }
}
