package com.company.DecoratorPattern.SongGenres;

import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class Soul extends SongDecorator {
    public Soul(Song song) {
        super(song);
        song.getGenres().add("Soul");
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
//        genres.add("Soul");
//        super.getGenres().addAll(genres);
        return super.getGenres();
    }
}
