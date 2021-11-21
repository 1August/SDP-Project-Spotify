package com.company.Repositories;

import com.company.Entities.Artist;
import com.company.Entities.Subscriber;
import com.company.ObserverPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    static List<Artist> artists = new ArrayList<>();
//    exists find get

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
//        List<String> subscribers = new ArrayList<>();
//        for (Artist artist : artists) {
//            if (artist.getName().equals(name) && artist.getSurname().equals(surname)){
//                for (Observer observer : artist.getSubscriber()) {
//                    subscribers.add(observer.getInfo());
//                }
//                return subscribers;
//            }
//        }

        for (Artist artist : artists) {
            if (artist.getName().equals(name) && artist.getSurname().equals(surname)){
                return artist.getSubscriber();
            }
        }
        return null;
    }
}
