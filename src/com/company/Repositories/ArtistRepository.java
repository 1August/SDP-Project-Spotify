package com.company.Repositories;

import com.company.Entities.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    private static List<Artist> artists = new ArrayList<>();

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

//    public List<Artist> getArtists() {
//        return artists;
//    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
