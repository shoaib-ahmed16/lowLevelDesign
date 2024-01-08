package design.level.low.patterns.observerPattern.observable;

import design.level.low.patterns.observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservableImpl implements StockObservable{

    List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount=0;
    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer:observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        this.stockCount+=newStockAdded;
        if(this.stockCount!=0){
            notifySubscribers();
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
