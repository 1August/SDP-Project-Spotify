package com.company.Entities;

import com.company.AudioFormats.IFormat;

import java.util.ArrayList;
import java.util.List;

public class Song {
    //    private int id;
    private String songName;
    private int publishedYear;
    private String description;
    private List<String> genres = new ArrayList<>();
    private IFormat format;

    public Song(String songName, int publishedYear, String description, List<String> genres, IFormat format) {
        this.songName = songName;
        this.publishedYear = publishedYear;
        this.description = description;
        this.genres = genres;
        this.format = format;
        encode();
    }

    private void encode(){
        format.encode();
    }

    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public IFormat getFormat() {
        return format;
    }
    public void setFormat(IFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", publishedYear=" + publishedYear +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                ", formatName=" + format +
//                ", formatCode=" + format.getFormatCode() +
                '}';
    }
}
