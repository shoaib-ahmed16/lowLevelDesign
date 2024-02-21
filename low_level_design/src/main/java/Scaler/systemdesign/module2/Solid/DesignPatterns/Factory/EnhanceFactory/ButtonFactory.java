package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

//Step 3: factory Interface
public interface ButtonFactory {

    //Factory method
    Button createButton(Double radius, Double border, Double length);
}
