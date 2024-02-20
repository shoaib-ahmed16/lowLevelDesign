package Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackGroundObjectTest {

    @DisplayName("Test case: If the clone is called, a new Object with will be returned.")
    @Test
    void testClone(){
        // Step 3:  Create a prototype + clone it +modify it.
        BackGroundObject prototype= new BackGroundObject(0.0,0.0,10.0,10.0,BackGroundType.TREE);
        BackGroundObject clone =prototype.cloneObject();
        assertNotEquals(prototype,clone);
        assertEquals(prototype.getY(),clone.getY());
        assertEquals(prototype.getType(),clone.getType());
        assertEquals(prototype.getX(),clone.getX());
        assertEquals(prototype.getHeight(),clone.getHeight());
        assertEquals(prototype.getWidth(),clone.getWidth());
        assertEquals(prototype.getPixels(),clone.getPixels());

    }

}