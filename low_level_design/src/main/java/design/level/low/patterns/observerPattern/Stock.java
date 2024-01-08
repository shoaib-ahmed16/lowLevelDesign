package design.level.low.patterns.observerPattern;

import design.level.low.patterns.observerPattern.observable.IPhoneObservableImpl;
import design.level.low.patterns.observerPattern.observable.StockObservable;
import design.level.low.patterns.observerPattern.observer.EmailAlertObserverImpl;
import design.level.low.patterns.observerPattern.observer.NotificationAlertObserver;

public class Stock {
    public  static void main(String[] args){
        StockObservable iphoneStockObservable = new IPhoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xzce@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("ilu@gmail.com",iphoneStockObservable);
        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);
        iphoneStockObservable.setStockCount(10);

    }
}
