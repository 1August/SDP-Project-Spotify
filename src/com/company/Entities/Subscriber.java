package com.company.Entities;

import com.company.FactoryPattern.SpotifyElements;
import com.company.ObserverPattern.Observer;
import com.company.StrategyPattern.NotPremium;
import com.company.StrategyPattern.PremiumBehaviour;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer, SpotifyElements{
    private String name;
    private String surname;
    private String email;
    private String password;
    private double balance;
    private boolean havePremium;
    private List<Song> likedSongs = new ArrayList<>();
    private PremiumBehaviour premiumBehaviour;

    @Override
    public void update(List<Song> songs, String artistName) {
        System.out.println("\nHello " + this.email +", available songs: \n" + artistName);
        for (Song song : songs) {
            System.out.println(song.getSongName());
        }
    }

    @Override
    public String getInfo() {
        return "\t Name - '" + name + "'\n" +
                "\t Surname - '" + surname + "'\n" +
                "\t Email - '" + email + "'\n" +
                "\t PremuimStatus - '" + havePremium;
    }

    public void showSubscription(){
        this.premiumBehaviour.showSubscriptionStatus();
    }

    public void addSongToPlaylist(Song song){
        if (havePremium){
            likedSongs.add(song);
            System.out.println("Song - " + song.getSongName() + " added to your playlist");
        }
    }

    public Subscriber(Subscriber subscriber) {
        this.name = subscriber.name;
        this.surname = subscriber.surname;
        this.email = subscriber.email;
        this.password = subscriber.password;
        this.balance = 0;
        this.havePremium = false;
        this.premiumBehaviour = new NotPremium();
    }

    public Subscriber(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.havePremium = false;
        this.premiumBehaviour = new NotPremium();
    }

    public List<Song> getSongs() {
        return likedSongs;
    }
    public void setSongs(List<Song> songs) {
        this.likedSongs = songs;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public PremiumBehaviour getPremiumBehaviour() {
        return premiumBehaviour;
    }
    public void setPremiumBehaviour(PremiumBehaviour premiumBehaviour) {
        this.premiumBehaviour = premiumBehaviour;
    }
    public boolean isHavePremium() {
        return havePremium;
    }
    public void setHavePremium(boolean havePremium) {
        this.havePremium = havePremium;
    }


    @Override
    public String toString() {
        return "Subscriber{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public String showInfo(){
        return "Subscriber{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
