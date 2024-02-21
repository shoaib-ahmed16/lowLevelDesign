package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor;

public interface PaymentProvider {
    void createPayment(PaymentRequest paymentRequest);
    PaymentStatus verifyStatus(Long id);

}
