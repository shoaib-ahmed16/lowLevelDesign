package Scaler.systemdesign.module1.concurrency.ExecutorsAndCallables.callable.adderSubtractor;

public class Count {

    private int value =0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementCount(int offset){
        this.value+=offset;
    }
    public synchronized void decrementCount(int offset){
        this.value-=offset;
    }
}
