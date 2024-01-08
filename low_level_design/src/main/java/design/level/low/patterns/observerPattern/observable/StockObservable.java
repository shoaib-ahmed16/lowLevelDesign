package design.level.low.patterns.observerPattern.observable;

import design.level.low.patterns.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscribers();
    void setStockCount(int newStockAdded);
    public int getStockCount();
}
