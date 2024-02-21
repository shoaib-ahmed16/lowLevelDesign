package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ButtonFactoryTest {

    @Test
    void testRoundButton(){
        //Condition dependency injection -> Qualifier
        ButtonFactory buttonFactory = new RoundButtonFactory();
        Button button = buttonFactory.createButton(10.0,20.0,null);
        assertTrue(button instanceof RoundButton);
    }
}