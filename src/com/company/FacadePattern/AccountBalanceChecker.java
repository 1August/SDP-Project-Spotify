package com.company.FacadePattern;

import com.company.Entities.Subscriber;
import com.company.StrategyPattern.Premium;
import com.company.StrategyPattern.PremiumBehaviour;

public class AccountBalanceChecker {
    private Subscriber subscriber;
    private PremiumBehaviour premiumBehaviour = new Premium();
    public AccountBalanceChecker(){}

    public AccountBalanceChecker(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public void decreaseMoney(double moneyToPurchase){
        if(subscriber.getBalance()<moneyToPurchase){
            System.out.println("You do not have enough money to buy plan.");
            System.out.println("Please, top up your balance.");
            return;
        }
        subscriber.setBalance(subscriber.getBalance() - moneyToPurchase);
        System.out.println("You successfully purchased");
        System.out.println("Your current balance: $" + subscriber.getBalance());
        premiumBehaviour.changeSubscriptionStatus(subscriber);
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
