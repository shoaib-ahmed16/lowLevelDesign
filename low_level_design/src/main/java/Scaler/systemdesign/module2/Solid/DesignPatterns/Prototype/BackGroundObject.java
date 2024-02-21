package Scaler.systemdesign.module2.Solid.DesignPatterns.Prototype;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Step 2 - Implement the Cloneable interface
@NoArgsConstructor
@Setter
@Getter
public class BackGroundObject implements  GraphicalObject{
    private Double x;
    private Double y;

    private Double width;
    private Double height;
    private BackGroundType type;
    @Setter(AccessLevel.NONE) // Do not create a setter
    private List<Double> pixels= new ArrayList<>();

    public BackGroundObject(Double x, Double y, Double width, Double height, BackGroundType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.pixels = generatePixels();
    }
    public  BackGroundObject(BackGroundObject ref){
        this.x=ref.x;
        this.y=ref.y;
        this.width=ref.width;
        this.height=ref.height;
        this.type=ref.type;
        this.pixels=ref.pixels;
    }

    private List<Double> generatePixels(){
        return Collections.emptyList();
    }
    @Override
    public BackGroundObject cloneObject() {
        return new BackGroundObject(this);
    }
}
