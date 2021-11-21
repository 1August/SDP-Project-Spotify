package com.company.Entities;

import com.company.ObserverPattern.Observer;

import java.util.List;

public class Subscriber implements Observer {
    //    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private double balance;

    public Subscriber(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public Subscriber(Subscriber subscriber) {
        new Subscriber(getName(), subscriber.getSurname(), subscriber.getEmail(), subscriber.getPassword());
    }

    @Override
    public void update(List<Song> songs, String artistName) {
        System.out.println("\nHello " + this.email +", available songs: \n" + artistName);
        for (Song song : songs) {
            System.out.println(song.getSongName());
        }
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
    public double getBalance(){return balance;}
    public void setBalance(double balance){this.balance = balance;}

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
}
