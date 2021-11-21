package com.company;

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
import com.company.FacadePattern.SpotifyArtistAccount;
import com.company.FacadePattern.SpotifySubAccount;
import com.company.ObserverPattern.Observer;
import netscape.javascript.JSObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

//    TODO:
//      change all subscribers to class observer and change artist to observable
//      FACTORY
//      STRATEGY

    static SpotifySubAccount spotifySubAccount = new SpotifySubAccount();
    static SpotifyArtistAccount spotifyArtistAccount = new SpotifyArtistAccount();
    static Subscriber temporarySubscriber;
    static Artist temporaryArtist;

    public static boolean loginAndRegisterSystem(boolean isArtist) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register");

        int choose = scanner.nextInt();
        if (choose == 1) {
            System.out.println("Enter your email: ");
            String email = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();
            if (isArtist) {
                temporaryArtist = spotifyArtistAccount.loginArtist(email, password);
                if (temporaryArtist == null)
                    return false;
                return true;
            }
            temporarySubscriber = spotifySubAccount.loginSub(email, password);
            if (temporarySubscriber == null)
                return false;
            return true;
        } else {
            System.out.println("Enter your name: ");
            String name = scanner.next();
            System.out.println("Enter your surname: ");
            String surname = scanner.next();
            System.out.println("Enter your email: ");
            String email = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();
            if (isArtist) {
                temporaryArtist = spotifyArtistAccount.saveArtist(new Artist(name, surname, email, password));
                if (temporaryArtist == null)
                    return false;
                return true;
            }
            temporarySubscriber = spotifySubAccount.saveSub(new Subscriber(name, surname, email, password));
            if (temporarySubscriber == null)
                return false;
            return true;
        }
    }

    public static void buyPlans(){
        System.out.println("Subscription plans: ");
        System.out.println("1.Spotify Premium - $4.99/month");
        System.out.println("2.Spotify Premium Duo - $6.49/month");
        System.out.println("3.Spotify Premium Family  - $7.99/month");
        System.out.println("4.Spotify Premium Student - $2.49/month");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        System.out.println("Choose purchase: ");
        if (choose == 0) {
            System.out.println("Thank you! Enjoy:)");
        } else {
            System.out.println(temporarySubscriber.getBalance());
            switch (choose) {
                case (1):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 4.99);
                    break;
                case (2):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 6.49);
                    break;
                case (3):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 7.99);
                    break;
                case (4):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 2.42);
                    break;
            }
        }
    }

//      TODO: NEED TO REPLACE WHILE LOOP
//    public function(){
//        Scanner scanner = new Scanner(System.in);
//        int choose;
//
//        System.out.println("Welcome to your Spotify");
//        System.out.println("------------------------------");
//        System.out.println("1. Add song");
//        System.out.println("2. List all my songs");
//        System.out.println("3. List all my subscribers");
//        System.out.println("4. List all artists");
//        System.out.println("0. Exit");
//
//        choose = scanner.nextInt();
//        switch (choose){
//            case 1:
//                Date dt=new Date();
//                int year=dt.getYear();
//                int currentYear=year+1900;
//                System.out.println("Enter the name of the song: ");
//                String songName = scanner.next();
//                System.out.println("Enter the description of the song: ");
//                String songDesc = scanner.next();
//                System.out.println("Choose genres of the song: ");
//                System.out.println("EDM");
//                System.out.println("Hip-hop/Rap");
//                System.out.println("K-Pop");
//                System.out.println("Rock");
//                System.out.println("Enter stop to stop entering genres");
//                List<String> genres = new ArrayList<>();
//                while(!scanner.next().equals("stop")){
//                    genres.add(scanner.next());
//                }
//                spotifyArtistAccount.addSong(temporaryArtist.getEmail(), new Song(songName, currentYear, songDesc, genres, iFormat));
//                function();
//            case 2:
//                System.out.println(spotifyArtistAccount.getArtistSongs(temporaryArtist.getEmail()));
//                function();
//            case 3:
//                for (Observer subscriber : spotifyArtistAccount.getSubscribersOf(temporaryArtist.getName(), temporaryArtist.getSurname())) {
//                    System.out.println(subscriber.getInfo());
//                }
//                function();
//            case 4:
//
//            case 0:
//                function();
//        }
//    }


    public static void main(String[] args) {


//        //<-- Song and artist creation, register user (Observer, Decorator, Adapter) -->
        WAVFormat wavFormat = new WAVFormat();
        IFormat iFormat = new MP3Format(wavFormat);
        iFormat.encode();

        Song song1 = new EDM(new KPop(new Top10(new Song("Song1", 2020, "sdgdsgs", "", iFormat))));
        Song song2 = new HipHopAndRap(new Song("Song2", 2020, "sdgdsgs", "", iFormat));

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);

        spotifyArtistAccount.saveArtist(new Artist("Maksat", "Artist1", "artist1@example.com", "qwerty", songs));
        spotifyArtistAccount.saveArtist(new Artist("Akbala", "Artist2", "artist2@example.com", "qwerty"));

        spotifySubAccount.saveSub(new Subscriber("n1", "ns1", "1111", "123"));
        spotifyArtistAccount.getArtist("artist1@example.com").register(spotifySubAccount.getSub("1111"));


        song1.getFormat().encode();


//

//        spotifySubAccount.saveSub(new Subscriber("M", "K", "maks", "123"));
//        System.out.println(spotifySubAccount.loginSub("maks", "123").toString());

//        System.out.println(spotifyArtistAccount.loginArtist("artist1@example.com", "qwerty").toString());

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        Scanner scanner = new Scanner(System.in);
        int choose;

        System.out.println("Are you artist?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        choose = scanner.nextInt();

        boolean isLogined = loginAndRegisterSystem(choose == 1);

//        System.out.println(spotifySubAccount.);

        if (isLogined && choose == 1) {
            while(true){
                System.out.println("Welcome to your Spotify");
                System.out.println("------------------------------");
                System.out.println("1. Add song");
                System.out.println("2. List all my songs");
                System.out.println("3. List all my subscribers");
                System.out.println("4. List all artists");
                System.out.println("0. Exit");

                choose = scanner.nextInt();
                switch (choose){
                    case 1:
                        Date dt=new Date();
                        int year=dt.getYear();
                        int currentYear=year+1900;
                        System.out.println("Enter the name of the song: ");
                        String songName = scanner.next();
                        System.out.println("Enter the description of the song: ");
                        String songDesc = scanner.next();
                        System.out.println("Choose genres of the song: ");
                        System.out.println("EDM");
                        System.out.println("Hip-hop/Rap");
                        System.out.println("K-Pop");
                        System.out.println("Rock");
                        System.out.println("Enter stop to stop entering genres");
                        List<String> genres = new ArrayList<>();
                        while(!scanner.next().equals("stop")){
                            genres.add(scanner.next());
                        }
                        spotifyArtistAccount.addSong(temporaryArtist.getEmail(), new Song(songName, currentYear, songDesc, genres, iFormat));
                        break;
                    case 2:
                        System.out.println(spotifyArtistAccount.getArtistSongs(temporaryArtist.getEmail()));
                        break;
                    case 3:
                        for (Observer subscriber : spotifyArtistAccount.getSubscribersOf(temporaryArtist.getName(), temporaryArtist.getSurname())) {
                            System.out.println(subscriber.getInfo());
                        }
                        break;
                    case 4:

                    case 0:
                        break;
                }
            }
        } else if (isLogined && choose == 2) {
            while (true) {
                System.out.println("Welcome to your Spotify!");
                System.out.println("------------------------------");
                System.out.println("1. Buy plans");
                System.out.println("2. Top up balance");
                System.out.println("3. List all artists");
                System.out.println("4. List songs of artist");
                System.out.println("0. Exit");

                choose = scanner.nextInt();
                switch (choose){
                    case 1:
                        buyPlans();
                        break;
                    case 2:
                        System.out.println("Money to add: ");
                        Scanner scanner1 = new Scanner(System.in);
                        double m = scanner1.nextDouble();
                        spotifySubAccount.addMoney(temporarySubscriber, m);
                        break;
                    case 3:
                        for (Artist artist : spotifySubAccount.getAllArtist()) {
                            System.out.println(artist.toString());
                        }
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Enter the name of artist: ");
                        String artistName = scanner.next();
                        System.out.println("Enter the surname of artist: ");
                        String artistSurname = scanner.next();
                        for (Song song : spotifySubAccount.getSongsOfArtist(artistName, artistSurname)) {
                            System.out.println(song.toString());
                        }
                        System.out.println();
                        break;
                    case 0:
                        break;
                }

//                System.out.println("Welcome to your Spotify. You can buy Spotify Premium!");
//                System.out.println("(if you want to top up your balance type 5)");
//                System.out.println("(if you want to stop purchase type 0)");

//                choose = scanner.nextInt();
//                boolean result = buyPlans();
//                if (!result) break;
//                else continue;
            }
        }
    }
}

