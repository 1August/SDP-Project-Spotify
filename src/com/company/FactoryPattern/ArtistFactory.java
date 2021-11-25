package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Subscriber;
import com.company.Entities.Song;
import com.company.Repositories.ArtistRepository;

public class ArtistFactory implements SpotifyFactory{
    ArtistRepository artistRepository = new ArtistRepository();

    @Override
    public SpotifyElements createSpotifyElement(String artistEmail, Song song) {
        return null;
    }

    @Override
    public SpotifyElements createSpotifyElement(Artist artist) {
        artistRepository.saveArtist(artist);
        return artist;
    }

    @Override
    public SpotifyElements createSpotifyElement(Subscriber subscriber) {
        return null;
    }
}
