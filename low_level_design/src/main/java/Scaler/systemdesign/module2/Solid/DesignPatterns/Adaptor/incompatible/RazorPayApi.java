package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor.incompatible;

//SDK
// Step 0: Incompatible Interfaces
public class RazorPayApi {

    public void prePay(Long id,String name,String email, Double amount){
        System.out.println("Razor Pre-Pay Payment");
    }
    public void pay(Long id,String name,String email, Double amount){
        System.out.println("Razor Pay Payment");
    }
    public RazorPayStatus checkStatus(Long id){
        return RazorPayStatus.OK;
    }
}
