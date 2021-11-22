package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

public class SubscriberFactory implements SpotifyFactory{
//    @Override
//    public SpotifyElements createSpotifyElement() {
//        return new Subscriber();
//    }

    @Override
    public SpotifyElements createSpotifyElement(Song song) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Artist artist) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Subscriber subscriber) {
        return new Subscriber(subscriber);
    }
}
