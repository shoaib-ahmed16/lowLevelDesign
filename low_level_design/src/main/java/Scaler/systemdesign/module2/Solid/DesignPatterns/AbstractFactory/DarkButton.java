package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

public class DarkButton extends Button {
    private Double radius;

    public Double getRadius() {
        return radius;
    }

    @Override
    public void onClick(){
        System.out.println("Round Button was clicked!");
    }
    @Override
    public void render(){
        System.out.println("Rendered!");
    }

    public DarkButton(Double radius, Double border) {
        super(border);
        this.radius = radius;
    }
}