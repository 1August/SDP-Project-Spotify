package com.company.DecoratorPattern.SongGenres;

import com.company.AudioFormats.IFormat;
import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.Collections;
import java.util.List;

public class KPop extends SongDecorator {
    public KPop(Song song) {
        super(song);
    }
    List<String> genres = super.getGenres();

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
        genres.add("K-Pop");
        return genres;
    }

}
