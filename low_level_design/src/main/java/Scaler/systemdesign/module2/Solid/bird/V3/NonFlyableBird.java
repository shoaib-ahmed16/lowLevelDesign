package Scaler.systemdesign.module2.Solid.bird.V3;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class NonFlyableBird extends Bird{
    public NonFlyableBird(String name, Double weight, BirdType type, Color color, Size size) {
        super(name, weight, type, color, size);
    }
}
