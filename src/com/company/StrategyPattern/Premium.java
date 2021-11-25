package com.company.StrategyPattern;

import com.company.Entities.Subscriber;

public class Premium implements PremiumBehaviour{

    @Override
    public void showSubscriptionStatus() {
        System.out.println("You are premium");
    }

    @Override
    public void changeSubscriptionStatus(Subscriber subscriber) {
        subscriber.setHavePremium(true);
    }
}
