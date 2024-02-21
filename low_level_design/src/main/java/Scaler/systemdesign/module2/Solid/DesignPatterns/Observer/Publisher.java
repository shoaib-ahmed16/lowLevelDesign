package Scaler.systemdesign.module2.Solid.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

//Step 1: Create an interface for publisher + registry
public abstract class Publisher {

    private List<Consumer> consumers= new ArrayList<>();
    public void publish(Double price){
        consumers.forEach(consumer -> consumer.consume(price));
    }
    public  void addConsumer(Consumer consumer){
        consumers.add(consumer);
    }
    public void removeConsumer(Consumer consumer){
        consumers.remove(consumer);
    }
}
