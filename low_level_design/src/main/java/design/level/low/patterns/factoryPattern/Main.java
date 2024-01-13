package design.level.low.patterns.factoryPattern;

public class Main {
    public  void d(){
        System.out.println();
    }
    public static  void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape =shapeFactory.getShape("Square");
        shape.draw();
    }
}

