package design.level.low.patterns.decoratorPattern;

public class ExtraCheese extends  ToppingDecorator{

    private BasePizza basePizza;

    public ExtraCheese(BasePizza pizza){
        this.basePizza=pizza;
    }
    @Override
    public int cost() {
        System.out.println("Adding Extar chess  Pizza Price :10 to the Pizza Price: "+this.basePizza.cost());
        return this.basePizza.cost()+10;
    }
}
