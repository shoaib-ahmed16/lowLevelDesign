package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

//Step 2: Create Concrete product Classes
public class DarkRadio extends Radio{
    @Override
    public void onSelect() {
        System.out.println("Dark Radio Button is selected!");
    }

    @Override
    public void render() {
        System.out.println("Dark Radio Button is render!");
    }
}
