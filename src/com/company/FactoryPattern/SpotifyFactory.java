package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

public interface SpotifyFactory {
    SpotifyElements createSpotifyElement(String artistEmail, Song song);
    SpotifyElements createSpotifyElement(Artist artist);
    SpotifyElements createSpotifyElement(Subscriber subscriber);
}
