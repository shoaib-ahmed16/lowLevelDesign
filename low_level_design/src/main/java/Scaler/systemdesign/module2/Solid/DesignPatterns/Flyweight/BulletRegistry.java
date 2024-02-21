package Scaler.systemdesign.module2.Solid.DesignPatterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    private Map<BulletType,Bullet> bullets= new HashMap<>();

    public void addBullet(Bullet bullet){
        bullets.put(bullet.getType(),bullet);
    }
    public Bullet getBullet(BulletType type){
        return bullets.get(type);
    }
    public Bullet removeBullet(BulletType type){
        return bullets.remove(type);
    }
}
