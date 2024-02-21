package Scaler.systemdesign.module2.Solid.DesignPatterns.Registry;

import Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype.BackGroundObject;
import Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype.BackGroundType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackGroundObjectRegistryTest {

    @Test
    void testRegistry(){
        // Create a prototype
        BackGroundObject prototype= new BackGroundObject(0.0,0.0,10.0,10.0, BackGroundType.TREE);
        BackGroundObject clone =prototype.cloneObject();
        clone.setType(BackGroundType.BUILDING);

        // add a prototype to the registry
        BackGroundObjectRegistry registry= new BackGroundObjectRegistry();
        registry.addPrototype(prototype);
        registry.addPrototype(clone);

        // Fetch the prototype.
        BackGroundObject obj =registry.getPrototype(BackGroundType.BUILDING);
        BackGroundObject obj2 =registry.getPrototype(BackGroundType.TREE);
        assertEquals(prototype.getType(),obj2.getType());
        assertEquals(clone.getType(),obj.getType());

    }
}