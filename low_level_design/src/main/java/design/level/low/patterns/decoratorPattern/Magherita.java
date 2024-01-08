package design.level.low.patterns.decoratorPattern;

public class Magherita extends BasePizza{
    @Override
    public int cost() {
        System.out.println("Adding Magherita Pizza Price :150");
        return 150 ;
    }
}
