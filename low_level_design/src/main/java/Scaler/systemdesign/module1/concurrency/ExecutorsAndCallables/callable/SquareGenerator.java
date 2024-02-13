package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable;

import java.util.concurrent.Callable;

public class SquareGenerator implements Callable<Integer> {
    private Integer number;
    @Override
    public Integer call() throws Exception {
        return this.number * this.number;
    }
    public SquareGenerator(Integer number){
        this.number=number;
    }
}
