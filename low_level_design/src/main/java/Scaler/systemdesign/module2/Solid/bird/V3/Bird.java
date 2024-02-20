package Scaler.systemdesign.module2.Solid.bird.V3;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class Bird {
    private String name;
    private Double weight;
    private BirdType type=BirdType.EAGLE;
    private Color color;
    private Size size;
    public void sleep(){
        System.out.println("I'm hungry! Let's eat");
    }
    public void eat(){
        System.out.println("I ate a lot! Let's sleep");
    }
    public Bird(String name,Double weight,BirdType type,Color color,Size size){
        this.name=name;
        this.weight=weight;
        this.type=type;
        this.color=color;
        this.size=size;
    }
}
