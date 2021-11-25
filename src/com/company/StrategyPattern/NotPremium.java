package com.company.StrategyPattern;

import com.company.Entities.Subscriber;

public class NotPremium implements PremiumBehaviour{

    @Override
    public void showSubscriptionStatus() {
        System.out.println("You are not premium");
    }

    @Override
    public void changeSubscriptionStatus(Subscriber subscriber) {
        subscriber.setHavePremium(false);
    }
}
