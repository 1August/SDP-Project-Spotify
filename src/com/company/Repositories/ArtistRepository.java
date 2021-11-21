package com.company.Repositories;

import com.company.Entities.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    List<Artist> artists  = new ArrayList<>();


//    exists find get

    public Artist getArtist(String email){
        for (Artist artist : artists) if (artist.getLogin().equals(email)) return artist;
        return null;
    }

    public Artist loginArtist(String email, String password){
        for (Artist artist : artists) if (artist.getLogin().equals(email) && artist.getPassword().equals(password)) return artist;
        return null;
    }

    public void registerArtist(Artist artist){
        artists.add(artist);
    }
}
