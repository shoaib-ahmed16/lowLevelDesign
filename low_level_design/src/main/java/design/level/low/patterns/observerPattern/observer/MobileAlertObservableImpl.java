package design.level.low.patterns.observerPattern.observer;

import design.level.low.patterns.observerPattern.observable.StockObservable;

public class MobileAlertObservableImpl implements NotificationAlertObserver{
    String userName;
    StockObservable observable;

    public  MobileAlertObservableImpl(String userName,StockObservable observable){
        this.observable =observable;
        this.userName=userName;
    }
    @Override
    public void update() {
        sendMessageOnMobile(userName,"product is in Stock hurry up!");
    }
    private void sendMessageOnMobile(String userName,String msg){
        System.out.println("msg sent to: "+userName);
    }
}
