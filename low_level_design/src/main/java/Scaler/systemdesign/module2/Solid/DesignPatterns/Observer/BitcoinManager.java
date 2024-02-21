package Scaler.systemdesign.module2.Solid.DesignPatterns.Observer;

import lombok.AllArgsConstructor;

//Step 2: Extend the publisher class
@AllArgsConstructor
public class BitcoinManager extends Publisher {
    private Bitcoin bitcoin;
    public void setPrice(Double price){
        if(bitcoin.getPrice() -price >5.0) {
            super.publish(price);
        }
        bitcoin.setPrice(price);
    }
}
