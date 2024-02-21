package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

// Step 3: Factory Interface
public interface ThemeFactory {
    Button createButton(Double border, Double length, Double radius);
    Radio createRadio();
}
