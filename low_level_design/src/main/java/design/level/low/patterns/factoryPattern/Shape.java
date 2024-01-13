package design.level.low.patterns.factoryPattern;

public sealed interface Shape permits Circle,Rectangle,Square {
    void draw();
}
