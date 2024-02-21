package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.SimpleFactory;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.ScreenSize;

// Step 3: Create Factory class
public class ButtonFactory {

    public static Button createButton(ScreenSize screenSize, Double radius, Double border, Double length){
        switch (screenSize){
            case MOBILE, TABLET : return new RoundButton(radius,border);
            case DESKTOP, WEB_BROWSER : return new SquareButton(length,border);
        }
        throw new RuntimeException("Invalid Type: "+screenSize);
    }
}
