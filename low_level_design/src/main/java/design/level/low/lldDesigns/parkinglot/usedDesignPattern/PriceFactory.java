package design.level.low.lldDesigns.parkinglot.usedDesignPattern;

import design.level.low.lldDesigns.parkinglot.domain.Price;

public class PriceFactory {
    private PriceFactory(){}

    public static Price getPriceType(String type){
        if(type.equalsIgnoreCase("hr"))
            return Price.HOURLY;
        else if(type.equalsIgnoreCase("fix"))
            return Price.FIXED;
        else
            throw new RuntimeException("Invalid price category");

    }
}
