package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

public class DarkThemeFactory implements ThemeFactory{
    @Override
    public Button createButton(Double border, Double length, Double radius) {
        return new DarkButton(radius,border);
    }

    @Override
    public Radio createRadio() {
        return new DarkRadio();
    }
}
