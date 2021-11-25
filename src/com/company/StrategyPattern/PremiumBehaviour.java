package com.company.StrategyPattern;

import com.company.Entities.Subscriber;

public interface PremiumBehaviour   {
    void showSubscriptionStatus();
    void changeSubscriptionStatus(Subscriber subscriber);
}
