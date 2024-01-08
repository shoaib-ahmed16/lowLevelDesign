package design.level.low.patterns.observerPattern.observer;

import design.level.low.patterns.observerPattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public  EmailAlertObserverImpl(String emailId,StockObservable observable){
        this.observable =observable;
        this.emailId=emailId;
    }
    @Override
    public void update() {
        sendEmail(emailId,"product is in Stock hurry up!");
    }
    private void sendEmail(String emailId,String msg){
        System.out.println("mail sent to: "+emailId);
    }
}
