package design.level.low.patterns.factoryPattern;

public class ShapeFactory {

   public Shape getShape(String type){
       switch (type.toUpperCase()) {
           case "CIRCLE":
               return new Circle();
           case "SQUARE":
               return new Square();
           case "RECTANGLE":
               return new Rectangle();
           default:
               throw new RuntimeException("Cannot return the Object or Require Type.");
       }
   }
}
