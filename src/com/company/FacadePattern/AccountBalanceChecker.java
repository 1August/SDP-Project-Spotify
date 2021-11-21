package com.company.FacadePattern;

import com.company.Entities.Subscriber;

public class AccountBalanceChecker {
    private Subscriber subscriber;

    public AccountBalanceChecker(){}

    public AccountBalanceChecker(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public boolean haveEnoughMoney(double purchaseMoney) {
        if(purchaseMoney > subscriber.getBalance()){
            System.out.println("You do not have enough money");
            System.out.println("Current balance: $" + subscriber.getBalance());
            return false;
        }
        decreaseMoney(purchaseMoney);
        System.out.println("Purchase completed successfully! Enjoy:)");
        System.out.println("Your current balance: $" + subscriber.getBalance());
        return true;
    }

    public void decreaseMoney(double moneyToPurchase){
        subscriber.setBalance(subscriber.getBalance() - moneyToPurchase);
        System.out.println("You successfully purchased");
        System.out.println("Your current balance: $" + subscriber.getBalance());
    }

    public void increaseMoney(double moneyForInserting){
        subscriber.setBalance(subscriber.getBalance() + moneyForInserting);
        System.out.println("You successfully added $"+ moneyForInserting + " into your balance!");
        System.out.println("Your current balance: $" + subscriber.getBalance());
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
