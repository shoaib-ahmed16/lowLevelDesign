package Scaler.systemdesign.module2.Solid.DesignPatterns.Observer;

public class EmailConsumer implements Consumer{
    @Override
    public void consume(Double price) {
        System.out.println("Sending email for price: "+price);
    }
}
