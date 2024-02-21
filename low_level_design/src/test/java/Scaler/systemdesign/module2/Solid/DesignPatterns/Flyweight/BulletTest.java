package Scaler.systemdesign.module2.Solid.DesignPatterns.Flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulletTest {

    @Test
    void createFlyweight(){
        BulletRegistry registry = new BulletRegistry();
        Bullet bullet = new Bullet(0.9,24.00,"image",BulletType.NINE_MM);
        Bullet bullet2 = new Bullet(0.6,12.00,"image2",BulletType.ACP);
        registry.addBullet(bullet);
        registry.addBullet(bullet2);
        FlyingBullet flyingBullet= new FlyingBullet(0.0,0.0,0.0,-12.0,registry.getBullet(BulletType.NINE_MM));
        FlyingBullet flyingBullet2= new FlyingBullet(10.0,12.0,45.0,55.0,registry.getBullet(BulletType.ACP));
    }

}