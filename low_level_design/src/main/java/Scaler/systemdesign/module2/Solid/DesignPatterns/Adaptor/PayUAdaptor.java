package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible.PayUApi;
import Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible.PayUStatus;

public class PayUAdaptor implements PaymentProvider{
    private PayUApi payUApi= new PayUApi();
    @Override
    public void createPayment(PaymentRequest payReq) {
        payUApi.makePayment(payReq.getId(),payReq.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        PayUStatus status=payUApi.checkStatus(id);
        return to(status);
    }

    private PaymentStatus to(PayUStatus status){
        switch (status){
            case SUCCESS: return PaymentStatus.DONE;
            case FAILURE: return PaymentStatus.FAILED;
        }
        throw new RuntimeException("Invalid Status:"+status);
    }
}
