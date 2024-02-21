package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProviderTest {
    PaymentProvider adapter= new RazorPayAdaptor();
//    PaymentProvider adapter2= new PayUAdaptor();
    @Test
    void testPayMethod(){
        PaymentRequest paymentRequest = new PaymentRequest(1L,"Titan ","ads@gmail.com",100.0);
        adapter.createPayment(paymentRequest);
    }
    @Test
    void testPayStatus(){
        System.out.println(adapter.verifyStatus(1L));
    }
}