package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

public class RoundButtonFactory implements ButtonFactory{
    @Override
    public Button createButton(Double radius, Double border, Double length) {
        return new RoundButton(radius,border);
    }
}
