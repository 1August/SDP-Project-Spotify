package com.company.FactoryPattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;
import com.company.FacadePattern.SpotifyArtistAccount;

public class SongFactory implements SpotifyFactory{
//    @Override
//    public SpotifyElements createSpotifyElement() {
//        return new Song();
//    }

    SpotifyArtistAccount spotifyArtistAccount = new SpotifyArtistAccount();

    @Override
    public SpotifyElements createSpotifyElement(String artistEmail, Song song) {
        spotifyArtistAccount.addSong(artistEmail, song);
        return song;
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
