package Scaler.systemdesign.module2.Solid.DesignPatterns.Strategy;

import lombok.AllArgsConstructor;

// Step 3: Adding a reference to context class
@AllArgsConstructor
public class Navigator {
    private NavigationStrategy navigationStrategy;

    public Double navigate(String from,String to){
        return navigationStrategy.navigate(from,to);
    }

}
