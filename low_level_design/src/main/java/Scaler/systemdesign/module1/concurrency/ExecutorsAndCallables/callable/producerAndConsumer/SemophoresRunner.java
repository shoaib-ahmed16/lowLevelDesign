package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.producerAndConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class SemophoresRunner {
    private static final Set<String> producerNames = Set.of("p1","p2","p3");
    private static final Set<String> consumerNames = Set.of("c1","c2","c3","c4","c5");
    public static void main(String[] args) {
        Queue<UnitOfWork> buffer=new ArrayDeque<>();
        Lock lock = new ReentrantLock();
        int maxSize=10;
        Set<Producer> producers = producerNames.stream().map(name-> new Producer(name,buffer,maxSize,lock)).collect(toSet());
        Set<Consumer> consumers = consumerNames.stream().map(name-> new Consumer(name,buffer,lock)).collect(toSet());
        producers.forEach(producer -> new Thread(producer).start());
        consumers.forEach(consumer -> new Thread(consumer).start());
    }
}
