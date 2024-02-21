package Scaler.systemdesign.module2.Solid.DesignPatterns.Facade;

public class OrderProcessorImpl implements OrderProcessor{
    private final InvetoryService  invetoryService=new InvetoryService();
    private final  PaymentService paymentService=new PaymentService();
    private final InvoiceService invoiceService=new InvoiceService();
    @Override
    public void process(Long orderId) {
        // Check for inventory
        if(!invetoryService.isPresent(orderId)){
            throw new RuntimeException("Stock not present!");
        }
        // Payment Gateway
        paymentService.processPayment(orderId);
        // Create Bill
        invoiceService.generateInvoice(orderId);
        // Send an email;
    }
}
