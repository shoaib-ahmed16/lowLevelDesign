package Scaler.systemdesign.module2.Solid.DesignPatterns.Strategy;

import org.junit.jupiter.api.Test;

class NavigatorTest {

    @Test
    void testBullet(){
        //HSR -> Indira Nagar
        // Two wheeler
        TwoWheelerStrategy strategy =new TwoWheelerStrategy();
        Navigator navigator = new Navigator(strategy); // Dependency Injection
        System.out.println(navigator.navigate("HSR","Indira Nagar"));

        // Four wheeler
        FourWheelerStrategy fourWheelerStrategy =new FourWheelerStrategy();
        Navigator navigator2 = new Navigator(fourWheelerStrategy); // Dependency Injection
        System.out.println(navigator2.navigate("HSR","Indira Nagar"));
    }
}