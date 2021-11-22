package com.company.Entities;

import com.company.AdapterPattern.AudioFormats.IFormat;
import com.company.AdapterPattern.AudioFormats.MP3Format;
import com.company.FactoryPattern.SpotifyElements;

import java.util.ArrayList;
import java.util.List;

public class Song implements SpotifyElements {
    //    private int id;
    private String songName;
    private int publishedYear;
    private String description;
    private List<String> genres;
    private String rating;
    private IFormat format;

//    public Song() {
//
//    }

    public Song(Song song) {
        this.songName = song.songName;
        this.publishedYear = song.publishedYear;
        this.description = song.description;
        this.genres = new ArrayList<>();
        this.format = song.format;
        this.rating = song.rating;
        encode();
    }

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

 /*   public void groupOfSetters(String songName, int publishedYear, String description, List<String> genres, String rating, IFormat format){
        setSongName(songName);
        setPublishedYear(publishedYear);
        setDescription(description);
        setFormat(format);
        setGenres(genres);
        setRating(rating);
    }*/

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
        return "Song{" +
                " songName='" + songName + '\'' +
                ", publishedYear=" + publishedYear +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                ", rating='" + rating + '\'' +
                ", format=" + format.getFormatInfo() +
                '}';
    }

    @Override
    public String showInfo(){
        return "\n\n\t Name of song - '" + getSongName() + "'\n" +
                "\t Published year - " + getPublishedYear() + '\n' +
                "\t Description - '" + getDescription() + "'\n" +
                "\t Genres - " + getGenres() + '\n' +
                "\t Rating - '" + getRating() + "'\n" +
                "\t Format - " + format.getFormatInfo();
    }
}
