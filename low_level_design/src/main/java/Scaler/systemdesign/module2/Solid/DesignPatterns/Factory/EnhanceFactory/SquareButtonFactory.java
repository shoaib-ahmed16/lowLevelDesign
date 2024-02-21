package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

public class SquareButtonFactory implements ButtonFactory{
    @Override
    public Button createButton(Double radius, Double border, Double length) {
        return new SquareButton(length,border);
    }
}
