package com.company.Repositories;

import com.company.Entities.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriberRepository {
    List<Subscriber> subs  = new ArrayList<>();

    public Subscriber getSubs(String subsEmail){
        for(Subscriber subscriber : subs) if(subscriber.getEmail().equals(subsEmail)) return subscriber;
        return null;
    }

    public Subscriber loginSubscriber(String email, String password) {
        for (Subscriber subscriber : subs) {
            if (subscriber.getEmail().equals(email) && subscriber.getPassword().equals(password))
                return subscriber;
        }
        return null;
    }

    public Subscriber saveSubscriber(Subscriber subscriber){
        subs.add(subscriber);
        return getSubs(subscriber.getEmail());
    }
}
