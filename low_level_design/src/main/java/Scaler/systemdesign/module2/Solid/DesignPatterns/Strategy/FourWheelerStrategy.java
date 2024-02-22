package Scaler.systemdesign.module2.Solid.DesignPatterns.Strategy;

//Step 2: Concrete Strategy class
public class FourWheelerStrategy implements NavigationStrategy{
    @Override
    public Double navigate(String from, String to) {
        // Geo-code the location
        // Distance between the locations
        // distance /speed
        return 2.3;
    }
}
