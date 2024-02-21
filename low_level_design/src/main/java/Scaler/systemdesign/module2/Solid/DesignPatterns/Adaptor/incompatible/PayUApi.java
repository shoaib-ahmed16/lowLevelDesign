package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible;

//SDK
// Step 0: Incompatible Interfaces
public class PayUApi {
    public void makePayment(Long id, Double amount){
        System.out.println("PayU  Payment");
    }
    public PayUStatus checkStatus(Long id){
        return PayUStatus.SUCCESS;
    }
}
