package Scaler.systemdesign.module2.Solid.DesignPatterns.Factory.EnhanceFactory;

// Step 2: Create the concrete product classes.
public class SquareButton extends Button {
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

    public SquareButton(Double length, Double border) {
        super(border);
        this.length = length;
    }
}
