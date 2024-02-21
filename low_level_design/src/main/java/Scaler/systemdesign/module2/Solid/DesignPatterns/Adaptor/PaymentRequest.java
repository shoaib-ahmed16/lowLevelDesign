package Scaler.systemdesign.module2.Solid.DesignPatterns.Adaptor;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentRequest {
   private  Long id;
   private String name;
   private String email;
   private Double amount;
}
