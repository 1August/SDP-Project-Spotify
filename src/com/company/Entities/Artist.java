package com.company.Entities;

import com.company.ObserverPattern.Observable;
import com.company.ObserverPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Artist implements Observable {
    //    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private List<Song> songs = new ArrayList<>();
    private List<Observer> subscriber= new ArrayList<>();

    public void addSong(Song song){
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

    public Artist(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
}
