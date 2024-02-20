package Scaler.systemdesign.module2.Solid.bird.V1;

import Scaler.systemdesign.module2.Solid.bird.utils.BirdType;
import Scaler.systemdesign.module2.Solid.bird.utils.Color;
import Scaler.systemdesign.module2.Solid.bird.utils.Size;

public class Bird {
    private String name;
    private Double weight;
    private BirdType type=BirdType.EAGLE;
    private Color color;
    private Size size;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Double getWeight() {return weight;}
    public void setWeight(Double weight) {this.weight = weight;}
    public BirdType getType() {return type;}
    public void setType(BirdType type) {this.type = type;}
    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}
    public Size getSize() {return size;}
    public void setSize(Size size) {this.size = size;}

    public void fly(){
        if(type==BirdType.EAGLE){
            System.out.println("Eagle is flying!");
        }else if(type==BirdType.PARROT){
            System.out.println("Parrot is flying!");
        }else if(type==BirdType.DOVE){
            System.out.println("Dove is flying!");
        }else if(type==BirdType.PEACOCK){
            System.out.println("Peacock is flying!");
        }else if(type==BirdType.SPARROW){
            System.out.println("Sparrow is flying!");
        }
    }
    public void sleep(){
        System.out.println("I'm hungry! Let's eat");
    }
    public void eat(){
        System.out.println("I ate a lot! Let's sleep");
    }
/*
Problems
1. Not Readable
2. Not easy to test
3. Merge Conflicts
4. Not reusable
 */
}
