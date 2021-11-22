package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

public class SongFactory implements SpotifyFactory{
//    @Override
//    public SpotifyElements createSpotifyElement() {
//        return new Song();
//    }

    @Override
    public SpotifyElements createSpotifyElement(Song song) {
        return new Song(song);
    }

    @Override
    public SpotifyElements createSpotifyElement(Artist artist) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Subscriber subscriber) {
        return null;
    }
}
