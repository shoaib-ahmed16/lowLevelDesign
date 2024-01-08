package design.level.low.patterns.decoratorPattern;

public class Mushroom extends ToppingDecorator{

    private BasePizza basePizza;

    public Mushroom(BasePizza pizza){
        this.basePizza=pizza;
    }
    @Override
    public int cost() {
        System.out.println("Adding Mushroom Pizza Price :30 to the Pizza Price: "+this.basePizza.cost());
        return this.basePizza.cost()+30;
    }
}
