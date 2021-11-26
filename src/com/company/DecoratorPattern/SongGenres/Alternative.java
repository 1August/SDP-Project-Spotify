package com.company.DecoratorPattern.SongGenres;

import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class Alternative extends SongDecorator {
    //    List<String> genres = super.getGenres();

    public Alternative(Song song) {
        super(song);
        song.getGenres().add("Alternative");
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
//        genres.add("Alternative");
//        super.getGenres().addAll(genres);
        return super.getGenres();
    }
}
