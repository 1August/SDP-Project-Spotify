package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;
import com.company.Repositories.SubscriberRepository;

public class SubscriberFactory implements SpotifyFactory{
//    @Override
//    public SpotifyElements createSpotifyElement() {
//        return new Subscriber();
//    }
    SubscriberRepository subscriberRepository = new SubscriberRepository();
    @Override
    public SpotifyElements createSpotifyElement(String artistEmail, Song song) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Artist artist) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Subscriber subscriber) {
        subscriberRepository.saveSubscriber(subscriber);
        return subscriber;
    }
}
