package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeFactoryTest {

    @Test
    void testDarkTheme(){
        ThemeFactory darkThemeFactory =new DarkThemeFactory();
        Button button = darkThemeFactory.createButton(0.5,10.0,null);
        Radio radio =darkThemeFactory.createRadio();
        assertTrue(button instanceof DarkButton);
        assertTrue(radio instanceof DarkRadio);
    }

}