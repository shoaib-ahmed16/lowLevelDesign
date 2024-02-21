package Scaler.systemdesign.module2.Solid.DesignPatterns.Observer;

public class SmsConsumer implements Consumer{
    @Override
    public void consume(Double price) {
        System.out.println("Sending sms for price: "+price);
    }
}
