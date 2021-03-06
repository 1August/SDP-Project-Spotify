package com.company.Entities;

import com.company.FactoryPattern.SpotifyElements;
import com.company.ObserverPattern.Observable;
import com.company.ObserverPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Artist implements Observable, SpotifyElements {
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Song> songs = new ArrayList<>();
    private List<Observer> subscriber = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
        notifyObserver();
    }

    @Override
    public void register(Observer observer) {
        this.subscriber.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.subscriber.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer subscriber : subscriber) subscriber.update(songs, this.name + " " + this.surname);
    }

    public Artist(Artist artist) {
        this.name = artist.name;
        this.surname = artist.surname;
        this.email = artist.email;
        this.password = artist.password;
    }

    public Artist(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public List<Observer> getSubscriber() {
        return subscriber;
    }
    public void setSubscriber(List<Observer> subscriber) {
        this.subscriber = subscriber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", songs=" + songs +
                ", subscriber=" + subscriber +
                '}';
    }

    @Override
    public String showInfo(){
        return  "\t Name of artist - " + name + "\n" +
                "\t Surname of artist -" + surname + "\n" +
                "\t Songs: \n" + songs + "\n\n" +
                "\t Subscribers: " + subscriber + '\n';
    }
}
