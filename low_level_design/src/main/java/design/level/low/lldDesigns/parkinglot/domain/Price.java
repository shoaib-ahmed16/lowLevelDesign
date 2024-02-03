package design.level.low.lldDesigns.parkinglot.domain;

public enum Price {
    HOURLY(50),
    FIXED(250);
    private final int price;
    public int getPrice(){
       return this.price;
    }
    Price(int price){
        this.price=price;
    }
}
