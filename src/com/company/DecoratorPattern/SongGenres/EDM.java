package com.company.DecoratorPattern.SongGenres;

import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class EDM extends SongDecorator {
//    List<String> genres = super.getGenres();

    public EDM(Song song) {
        super(song);
        song.getGenres().add("EDM");
    }



    @Override
    public String getSongName() {
        return super.getSongName();
    }

    @Override
    public int getPublishedYear() {
        return super.getPublishedYear();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public List<String> getGenres() {
//        List<String> genres = new ArrayList<>();
//        genres.add("EDM");
//        super.getGenres().addAll(genres);
        return super.getGenres();
    }

}
