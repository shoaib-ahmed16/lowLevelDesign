package Scaler.systemdesign.module2.Solid.DesignPatterns.Flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 1: Intrinsic state
@Getter
@AllArgsConstructor
public class Bullet {
    private Double radius;
    private Double weight;
    private String image;
    private BulletType type;

}
