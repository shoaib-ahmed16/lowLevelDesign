package Scaler.systemdesign.module2.Solid.DesignPatterns.Flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 2: Extrinsic State
@Getter
@AllArgsConstructor
public class FlyingBullet {
    private Double x,y,z;
    private Double direction;

//    Step 3: Add a has-a relation
    private Bullet bullet;


}
