package com.company.FacadePattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;
import com.company.FactoryPattern.ArtistFactory;
import com.company.FactoryPattern.SpotifyFactory;
import com.company.ObserverPattern.Observer;
import com.company.Repositories.ArtistRepository;
import com.company.Repositories.SubscriberRepository;

import java.util.List;

public class SpotifyArtistAccount {
    private static ArtistRepository artistRepository = new ArtistRepository();

    SpotifyFactory spotifyArtistFactory = new ArtistFactory();

//    private static SubscriberRepository subscriberRepository = new SubscriberRepository();
//    private static Artist artist = new Artist();

    public SpotifyArtistAccount(String name, String surname, String email, String password){
//        Artist artist = (Artist) spotifyArtistFactory.createSpotifyElement();
//        artist.
        artistRepository.saveArtist(new Artist(name, surname, email, password));
    }

    public SpotifyArtistAccount() {

    }

    public Artist getArtist(String email){
        return artistRepository.getArtist(email);
    }

    public Artist loginArtist(String email, String password){
        return artistRepository.loginArtist(email, password);
    }

    public List<Song> getArtistSongs(String email){
        return artistRepository.getArtist(email).getSongs();
    }

    public Artist saveArtist(Artist artist){
        artistRepository.saveArtist(artist);
        return artistRepository.getArtist(artist.getEmail());
    }

    public List<Artist> getAllArtist(){
        return artistRepository.getAllArtist();
    }

    public List<Song> getSongsOfArtist(String artistName, String artistSurname){
        return artistRepository.getArtistByNameAndSurname(artistName, artistSurname).getSongs();
    }

    public void addSong(String email, Song song){
        artistRepository.getArtist(email).addSong(song);
//        artist.addSong(song);
        System.out.println("Song - " + song.getSongName() + " added to your songlist");
    }

    public List<Observer> getSubscribersOf(String name, String surname){
        return artistRepository.getSubscribersOf(name, surname);
    }
}