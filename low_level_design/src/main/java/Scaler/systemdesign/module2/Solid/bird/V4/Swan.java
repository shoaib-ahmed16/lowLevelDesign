package Scaler.systemdesign.module2.Solid.bird.V4;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class Swan extends Bird implements FlyableBird,Swimmable{
    public Swan(String name, Double weight, BirdType type, Color color, Size size) {
        super(name, weight, type, color, size);
    }

    @Override
    public void eat(){
        System.out.println("I ate a lot! Let's sleep");
    }

    @Override
    public void sleep(){
        System.out.println("I'm hungry! Let's eat");
    }

    @Override
    public void fly() {
        System.out.println("Swan is flying!");
    }

    @Override
    public void swim() {
        System.out.println("Swan is swimming!");
    }
}
