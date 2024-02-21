package Scaler.systemdesign.module2.Solid.DesignPatterns.Observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BitcoinTest {
    private BitcoinManager bitcoinManager;

    //Setup => Create the dependencies
    @BeforeEach
    public void setUp(){
        Bitcoin bitcoin = new Bitcoin(100.0);
        bitcoinManager = new BitcoinManager(bitcoin);
        bitcoinManager.addConsumer(new EmailConsumer());
        bitcoinManager.addConsumer(new SmsConsumer());
    }

    //TearDown ==> Destroy the dependencies
    @Test
    void updatePrice(){
        bitcoinManager.setPrice(90.0);
    }
}