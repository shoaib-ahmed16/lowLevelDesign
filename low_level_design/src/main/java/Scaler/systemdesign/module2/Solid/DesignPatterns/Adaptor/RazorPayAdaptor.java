package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible.RazorPayApi;
import Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible.RazorPayStatus;

public class RazorPayAdaptor implements PaymentProvider{

    private RazorPayApi razorPayApi = new RazorPayApi();
    @Override
    public void createPayment(PaymentRequest payReq) {
        razorPayApi.prePay(payReq.getId(),payReq.getName(),payReq.getEmail(),payReq.getAmount());
        razorPayApi.pay(payReq.getId(),payReq.getName(),payReq.getEmail(),payReq.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        RazorPayStatus status = razorPayApi.checkStatus(id);
        return to(status);
    }
    private PaymentStatus to(RazorPayStatus status){
        switch (status){
            case OK : return PaymentStatus.DONE;
            case ERROR: return PaymentStatus.FAILED;
        }
        throw new RuntimeException("Invalid Status:"+status);
    }
}
