package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

//Step 2: Create Concrete product Classes
public class LightRadio extends Radio{
    @Override
    public void onSelect() {
        System.out.println("Light Radio Button is selected!");
    }

    @Override
    public void render() {
        System.out.println("Light Radio Button is render!");
    }
}
