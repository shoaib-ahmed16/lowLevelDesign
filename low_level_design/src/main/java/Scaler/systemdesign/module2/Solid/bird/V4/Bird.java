package Scaler.systemdesign.module2.Solid.bird.V4;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public abstract class Bird {
    private String name;
    private Double weight;
    private BirdType type=BirdType.EAGLE;
    private Color color;
    private Size size;
    public abstract void sleep();
    public abstract void eat();
    public Bird(String name,Double weight,BirdType type,Color color,Size size){
        this.name=name;
        this.weight=weight;
        this.type=type;
        this.color=color;
        this.size=size;
    }
}
