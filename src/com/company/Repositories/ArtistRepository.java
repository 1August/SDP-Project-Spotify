package com.company.Repositories;

import com.company.Entities.Artist;
import com.company.ObserverPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    static List<Artist> artists = new ArrayList<>();

    public Artist getArtist(String email){
        for (Artist artist : artists) if (artist.getEmail().equals(email)) return artist;
        return null;
    }

    public Artist getArtistByNameAndSurname(String name, String surname){
        for (Artist artist : artists) if (artist.getName().equals(name) && artist.getSurname().equals(surname)) return artist;
        return null;
    }

    public Artist loginArtist(String email, String password){
        for (Artist artist : artists) if (artist.getEmail().equals(email) && artist.getPassword().equals(password)) return artist;
        return null;
    }

    public void saveArtist(Artist artist){
        artists.add(artist);
    }

    public List<Artist> getAllArtist(){
        return artists;
    }

    public List<Observer> getSubscribersOf(String name, String surname){
        for (Artist artist : artists) {
            if (artist.getName().equals(name) && artist.getSurname().equals(surname))
                return artist.getSubscriber();
        }
        return null;
    }
    
    public boolean existsArtistByNameAndSurname(String name, String surname){
        for (Artist artist : artists) {
            if (artist.getName().equals(name) && artist.getSurname().equals(surname)) return true;
        }
        return false;
    }
    
    public boolean existsArtistByEmail(String email){
        for (Artist artist : artists) {
            if (artist.getEmail().equals(email)) return true;
        }
        return false;
    }

    public boolean subscribeToArtist(String artistName, String artistSurname, Observer observer){
        for (Artist artist : artists) {
            if (artist.getName().equals(artistName) && artist.getSurname().equals(artistSurname)){
                artist.register(observer);
                return true;
            }
        }
        return false;
    }
    
    public boolean unsubscribeFromArtist(String artistName, String artistSurname, Observer observer){
        for (Artist artist : artists) {
            if (artist.getName().equals(artistName) && artist.getSurname().equals(artistSurname)){
                artist.unregister(observer);
                return true;
            }
        }
        return false;
    }
}
