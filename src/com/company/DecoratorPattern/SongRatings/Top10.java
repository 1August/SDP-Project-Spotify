package com.company.DecoratorPattern.SongRatings;

import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.List;

public class Top10 extends SongDecorator {

    public Top10(Song song) {
        super(song);
    }

    public Top10(String songName, int publishedYear, String description, List<String> genres, String rating) {
        super(songName, publishedYear, description, genres, rating);
    }
    String rating(){
        return "Top-10";
    }

    @Override
    public String getRating() {
        return super.getRating()+this.rating();
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
        return super.getGenres();
    }

}
