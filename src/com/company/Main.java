package com.company;

//import com.company.AdapterPattern.AudioFormats.IFormat;
//import com.company.AdapterPattern.AudioFormats.MP3Format;
//import com.company.AdapterPattern.AudioFormats.WAVFormat;
//import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.AdapterPattern.AudioFormats.IFormat;
import com.company.AdapterPattern.AudioFormats.MP3Format;
import com.company.AdapterPattern.AudioFormats.WAVFormat;
import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.DecoratorPattern.SongGenres.HipHopAndRap;
import com.company.DecoratorPattern.SongGenres.KPop;
import com.company.DecoratorPattern.SongRatings.Top10;
import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;
import com.company.FacadePattern.SpotifyAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //<-- Song and artist creation, register user (Observer, Decorator, Adapter) -->
//        List<String> genres = new ArrayList<>();
//        WAVFormat wavFormat = new WAVFormat();
//        IFormat iFormat = new MP3Format(wavFormat);
//        iFormat.encode();
//        Song song1 = new EDM(new KPop(new Top10(new Song("Song1", 2020, "sdgdsgs", genres, "", iFormat))));
//        Song song2 = new HipHopAndRap(new Song("Song2", 2020, "sdgdsgs", genres, "", iFormat));
//        Artist artist1 = new Artist("Maksat", "Artist1", "artist1@example.com", "qwerty");
//        Artist artist2 = new Artist("Akbala", "Artist2", "artist2@example.com", "qwerty");
//        Subscriber subscriber1 = new Subscriber("Subs1", "Subs1", "subs1@example.com", "qwerty");
//        System.out.println(song1.toString());
//        song1.getFormat().encode();
//        System.out.println(song2.toString());
//        artist1.register(subscriber1);
//        artist2.register(subscriber1);
//        artist1.addSong(song1);
//        artist2.addSong(song2);

        //<-- Premium purchase (Facade) -->
        SpotifyAccount spotifyAccount = new SpotifyAccount("User1@gmail.com", "1234");
        System.out.println("Welcome to your Spotify. You can buy Spotify Premium!");
        while(true) {
            System.out.println("Subscription plans: ");
            System.out.println("1.Spotify Premium - $4.99/month\n" +
                    "2.Spotify Premium Duo - $6.49/month\n" +
                    "3.Spotify Premium Family  - $7.99/month\n" +
                    "4.Spotify Premium Student - $2.49/month\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose purchase: ");
            System.out.println("(if you want to top up your balance type 5)");
            System.out.println("(if you want to stop purchase type 0)");

            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println("Thank you! Enjoy:)");
                break;
            }
            else {
                switch (n) {
                    case (1):
                        spotifyAccount.purchaseMoney(4.99);
                        continue;
                    case (2):
                        spotifyAccount.purchaseMoney(6.49);
                        continue;
                    case (3):
                        spotifyAccount.purchaseMoney(7.99);
                        continue;
                    case (4):
                        spotifyAccount.purchaseMoney(2.49);
                        continue;
                    case (5):
                        System.out.println("Money to add: ");
                        Scanner scanner1 = new Scanner(System.in);
                        double m = scanner1.nextDouble();
                        spotifyAccount.addMoney(m);
                        continue;
                }
            }
        }

    }
}

