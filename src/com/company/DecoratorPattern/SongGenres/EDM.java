package com.company.DecoratorPattern.SongGenres;

import com.company.DecoratorPattern.SongDecorator;
import com.company.Entities.Song;

import java.util.Collections;
import java.util.List;

public class EDM extends SongDecorator {

    public EDM(Song song) {
        super(song);

    }
    String genre(){
        return "EDM";
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
        super.getGenres().add(this.genre());
        return super.getGenres();
    }


}
