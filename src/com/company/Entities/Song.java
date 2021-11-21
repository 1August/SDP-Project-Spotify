package com.company.Entities;

import com.company.AdapterPattern.AudioFormats.IFormat;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private Song song;
    //    private int id;
    private String songName;
    private int publishedYear;
    private String description;
    private List<String> genres = new ArrayList<>();
    private String rating;
    private IFormat format;

    public Song(String songName, int publishedYear, String description, String rating, IFormat format) {
        this.songName = songName;
        this.publishedYear = publishedYear;
        this.description = description;
        this.genres = new ArrayList<>();
        this.format = format;
        this.rating = rating;
        encode();
    }
    public Song(String songName, int publishedYear, String description, List<String> genres, IFormat format) {
        this.songName = songName;
        this.publishedYear = publishedYear;
        this.description = description;
        this.genres = genres;
        this.format = format;
        encode();
    }

    public Song(Song song) {
        this.song = song;
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
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public IFormat getFormat() {
        return format;
    }
    public void setFormat(IFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return  "\n\n\t Name of song - '" + getSongName() + "'\n" +
                "\t Published year - " + getPublishedYear() + '\n' +
                "\t Description - '" + getDescription() + "'\n" +
                "\t Genres - " + getGenres() + '\n' +
                "\t Rating - '" + getRating() + "'\n" +
                "\t Format - " + format;
    }
}
