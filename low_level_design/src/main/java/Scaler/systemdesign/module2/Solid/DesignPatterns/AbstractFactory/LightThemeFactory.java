package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

//Step 4: Create Concrete Factory classes
public class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton(Double border, Double length, Double radius) {
        return new LightButton(border,length);
    }

    @Override
    public Radio createRadio() {
        return new LightRadio();
    }
}
