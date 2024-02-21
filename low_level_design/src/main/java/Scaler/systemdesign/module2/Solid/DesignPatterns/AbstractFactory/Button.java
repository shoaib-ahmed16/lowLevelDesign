package Scaler.systemdesign.module2.Solid.DesignPatterns.AbstractFactory;

// Step 1: Create a common product Interface.
public abstract class Button {
    private Double border;

    public Double getBorder() {
        return border;
    }

    public abstract void onClick();
    public abstract void render();
    public Button(Double border){
        this.border=border;
    }

}
