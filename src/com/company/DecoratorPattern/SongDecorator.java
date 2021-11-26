package com.company.DecoratorPattern;

import com.company.AdapterPattern.AudioFormats.IFormat;
import com.company.Entities.Song;

import java.util.List;

public abstract class SongDecorator extends Song {
    private Song song;

    public SongDecorator(Song song){
        super(song);
        this.song = song;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////
// ОСТОРОЖНО Я ЗАКОМЕНТИЛ НО МОЖЕТ ГДЕ ТО ИСПОЛЬЗУЕТСЯ ТОЧНО НЕ ЗНАЮ - МАКС
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public SongDecorator(String songName, int publishedYear, String description, String rating, IFormat format) {
//        super(songName, publishedYear, description, rating, format);
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
// ОСТОРОЖНО Я ЗАКОМЕНТИЛ НО МОЖЕТ ГДЕ ТО ИСПОЛЬЗУЕТСЯ ТОЧНО НЕ ЗНАЮ - МАКС
//////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String getSongName() {
        return this.song.getSongName();
    }

    @Override
    public IFormat getFormat() {
        return this.song.getFormat();
    }

    @Override
    public int getPublishedYear() {
        return this.song.getPublishedYear();
    }

    @Override
    public String getDescription() {
        return this.song.getDescription();
    }

    @Override
    public List<String> getGenres() {
        return song.getGenres();
    }

    @Override
    public String getRating() {
        return this.song.getRating();
    }
}
