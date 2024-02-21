package Scaler.systemdesign.module2.Solid.DesignPatterns.Facade;

public class OrderManagerImpl implements OrderManager{
    private OrderProcessor orderProcessor=new OrderProcessorImpl();
    @Override
    public void checkout(Long orderId) {
        orderProcessor.process(orderId);
    }
}
