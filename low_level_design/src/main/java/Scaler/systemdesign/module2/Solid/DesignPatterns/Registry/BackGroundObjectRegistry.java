package Scaler.systemdesign.module2.Solid.DesignPatterns.Registry;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype.BackGroundObject;
import Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype.BackGroundType;

import java.util.HashMap;
import java.util.Map;

public class BackGroundObjectRegistry {

    private Map<BackGroundType,BackGroundObject> registry = new HashMap<>();
    public  void addPrototype(BackGroundObject object){
        registry.put(object.getType(),object);
    }
    public BackGroundObject removePrototype(BackGroundType type){
        return registry.remove(type);
    }
    public BackGroundObject getPrototype(BackGroundType type){
        return  registry.get(type);
    }
}
