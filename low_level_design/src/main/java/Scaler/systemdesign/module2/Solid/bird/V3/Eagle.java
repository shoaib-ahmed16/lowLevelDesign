package Scaler.systemdesign.module2.Solid.bird.V3;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class Eagle extends FlyableBird{
    public Eagle(String name, Double weight, BirdType type, Color color, Size size) {
        super(name, weight, type, color, size);
    }
    @Override
    public void fly() {
        System.out.println("Eagle is Flying!");
    }
}
