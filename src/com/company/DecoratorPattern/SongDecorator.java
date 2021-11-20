package com.company.DecoratorPattern;

import com.company.Entities.Song;

import java.util.List;

public abstract class SongDecorator extends Song {
    private Song song;

    public SongDecorator(Song song){
        super(song);
        this.song = song;
    }

    public SongDecorator(String songName, int publishedYear, String description, List<String> genres, String rating) {
        super(songName, publishedYear, description, genres, rating);
    }

    @Override
    public String getSongName() {
        return this.song.getSongName();
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
        return this.song.getGenres();
    }

    @Override
    public String getRating() {
        return this.song.getRating();
    }
}
