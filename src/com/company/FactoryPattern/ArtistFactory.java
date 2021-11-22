package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

public class ArtistFactory implements SpotifyFactory{
//    @Override
//    public SpotifyElements createSpotifyElement() {
//        return new Artist();
//    }

    @Override
    public SpotifyElements createSpotifyElement(Song song) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Artist artist) {
        return new Artist(artist);
    }

    @Override
    public SpotifyElements createSpotifyElement(Subscriber subscriber) {
        return null;
    }
}
