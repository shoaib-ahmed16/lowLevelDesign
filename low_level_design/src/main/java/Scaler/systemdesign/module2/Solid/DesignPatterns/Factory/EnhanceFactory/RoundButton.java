package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

// Step 2: Create the concrete product classes.
public class RoundButton extends Button {
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

    public RoundButton(Double radius, Double border) {
        super(border);
        this.radius = radius;
    }
}

