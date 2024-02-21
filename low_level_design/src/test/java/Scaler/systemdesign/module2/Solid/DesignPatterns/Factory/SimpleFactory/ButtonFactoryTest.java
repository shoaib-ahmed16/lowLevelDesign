package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.SimpleFactory;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.ScreenSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ButtonFactoryTest {

    @Test
    void testButton(){
        Button button= ButtonFactory.createButton(ScreenSize.DESKTOP,null,10.0,10.0);
        assertTrue(button instanceof SquareButton);
    }

}