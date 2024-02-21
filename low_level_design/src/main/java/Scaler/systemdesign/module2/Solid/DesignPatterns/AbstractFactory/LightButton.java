package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

public class LightButton extends Button {
    private Double length;

    public Double getLength() {
        return length;
    }

    @Override
    public void onClick(){
        System.out.println("Square Button was clicked!");
    }

    @Override
    public void render(){
        System.out.println("Rendered!");
    }

    public LightButton(Double length, Double border) {
        super(border);
        this.length = length;
    }
}