package Scaler.systemdesign.module2.Solid.bird.V3;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class Penguin extends NonFlyableBird{
    public Penguin(String name, Double weight, BirdType type, Color color, Size size) {
        super(name, weight, type, color, size);
    }
}
