package design.level.low.patterns.decoratorPattern;

public class Main {
    public  static  void main(String[] args){

        BasePizza magheritaPizzaWithExtraChessAndMushroom = new Mushroom(new ExtraCheese(new Magherita()));

        System.out.println(magheritaPizzaWithExtraChessAndMushroom.cost());
    }
}
