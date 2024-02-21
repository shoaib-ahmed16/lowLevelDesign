package Scaler.systemdesign.module2.Solid.DesignPatterns.Decorator;

import lombok.AllArgsConstructor;

// Step 3: Base decorator
@AllArgsConstructor
public abstract class BaseDecorator implements Datasource {
    protected Datasource nextLayer;
}
