package com.company;

import com.company.AdapterPattern.AudioFormats.*;
import com.company.DecoratorPattern.SongGenres.*;
import com.company.DecoratorPattern.SongRatings.*;
import com.company.Entities.*;
import com.company.FacadePattern.*;
import com.company.FactoryPattern.*;
import com.company.ObserverPattern.Observer;
import com.company.StrategyPattern.Premium;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

    /**
     *
     *     Maksat - Adapter
     *     Maksat + Akbala - Observer
     *     Olzhas - Decorator
     *     Olzhas + Akbala - Strategy
     *     Olzhas + Maksat: Facade, Factory
     *
     */

 public class Main {

    /**
     *
     * spotifySubAccount - facade pattern that helps to get all methods for Subscriber
     * spotifyArtistAccount - facade pattern that helps to get all methods for Artist
     *
     * temporarySubscriber - if user logins from subscriber account
     * temporaryArtist - if user logins from artist account
     *
     * factory - our factory class to create Subscribers, Artists and Songs
     *
     * wavFormat - old format that used
     * iFormat - new format to use
     *
     */

    static SpotifySubAccount spotifySubAccount = new SpotifySubAccount();
    static SpotifyArtistAccount spotifyArtistAccount = new SpotifyArtistAccount();
    static Subscriber temporarySubscriber;
    static Artist temporaryArtist;
    static SpotifyFactory factory = new ArtistFactory();

    static WAVFormat wavFormat = new WAVFormat();
    static IFormat iFormat = new MP3Format(wavFormat);

    /**
     * loginAndRegisterSystem() Login and registration system (methods)
     * @param isArtist is User artist or no
     */

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
                return temporaryArtist != null;
            }
            temporarySubscriber = spotifySubAccount.loginSub(email, password);
            return temporarySubscriber != null;
        } else if (choose == 2) {
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
                return temporaryArtist != null;
            }
            temporarySubscriber = spotifySubAccount.saveSub(new Subscriber(name, surname, email, password));
            return temporarySubscriber != null;
        }
        return false;
    }

    /**
     * buyPlans() Spotify premium purchase
     */

    public static void buyPlans(){

        if(temporarySubscriber.isHavePremium()){
            System.out.println("You already have premium");
            return;
        }
        System.out.println("Subscription plans: ");
        System.out.println("1.Spotify Premium - $4.99/month");
        System.out.println("2.Spotify Premium Duo - $6.49/month");
        System.out.println("3.Spotify Premium Family  - $7.99/month");
        System.out.println("4.Spotify Premium Student - $2.49/month");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        System.out.println("Choose purchase: ");
        if (choose == 0)
            System.out.println("Thank you! Enjoy:)");
        else {
            System.out.println(temporarySubscriber.getBalance());
            switch (choose) {
                case (1):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 4.99);
                    if(temporarySubscriber.isHavePremium()){
                        temporarySubscriber.setPremiumBehaviour(new Premium());
                        System.out.println("Now you have premium");
                    }
                    break;
                case (2):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 6.49);
                    if(temporarySubscriber.isHavePremium()){
                        temporarySubscriber.setPremiumBehaviour(new Premium());
                        System.out.println("Now you have premium");
                    }
                    break;
                case (3):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 7.99);
                    if(temporarySubscriber.isHavePremium()){
                        temporarySubscriber.setPremiumBehaviour(new Premium());
                        System.out.println("Now you have premium");
                    }
                    break;
                case (4):
                    spotifySubAccount.purchaseProduct(temporarySubscriber, 2.42);
                    if(temporarySubscriber.isHavePremium()){
                        temporarySubscriber.setPremiumBehaviour(new Premium());
                        System.out.println("Now you have premium");
                    }
                    break;
            }
        }
    }

    /**
     * artistServices() Artist services method
     */

    public static void artistServices(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your Spotify");
        System.out.println("------------------------------");
        System.out.println("1. Add song");
        System.out.println("2. List all my songs");
        System.out.println("3. List all my subscribers");
        System.out.println("4. List all artists");
        System.out.println("0. Exit");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                Date dt=new Date();
                int year = dt.getYear();
                int currentYear = year + 1900;
                System.out.println("Enter the name of the song: ");
                String songName = scanner.next();
                System.out.println("Enter the description of the song: ");
                String songDesc = scanner.next();
                System.out.println("Choose genres of the song: ");
                System.out.println("EDM");
                System.out.println("Hip-hop/Rap");
                System.out.println("K-Pop");
                System.out.println("Rock");
                System.out.println("Enter 'stop' to stop entering genres");
                List<String> genres = new ArrayList<>();
                String genre = scanner.next();
                while(!genre.equals("stop")){
                    genres.add(genre);
                    genre = scanner.next();
                }
                spotifyArtistAccount.addSong(temporaryArtist.getEmail(), new Song(songName, currentYear, songDesc, genres, iFormat));
                artistServices();
                break;
            case 2:
                System.out.println(spotifyArtistAccount.getArtistSongs(temporaryArtist.getEmail()));
                artistServices();
                break;
            case 3:
                for (Observer subscriber : spotifyArtistAccount.getSubscribersOf(temporaryArtist.getName(), temporaryArtist.getSurname()))
                    System.out.println(subscriber.getInfo());
                artistServices();
                break;
            case 4:
                for (Artist artist : spotifySubAccount.getAllArtist())
                    System.out.println(artist.showInfo());
                System.out.println();
                artistServices();
                break;
            case 0:
                break;
        }
    }

    /**
     *  subscriberServices() Subscriber services method
     */

    public static void subscriberServices() {
        Scanner scanner = new Scanner(System.in);
        String artistName = "";
        String artistSurname = "";

        System.out.println("Welcome to your Spotify!");
        System.out.println("------------------------------");
        System.out.println("1. Buy plans");
        System.out.println("2. Top up balance");
        System.out.println("3. List all artists");
        System.out.println("4. List songs of artist");
        System.out.println("5. Subscribe for artist");
        System.out.println("6. Unsubscribe from artist");
        System.out.println("7. Add song to my playlist");
        System.out.println("8. Show my playlist");
        System.out.println("0. Exit");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                buyPlans();
                subscriberServices();
                break;
            case 2:
                System.out.println("Money to add: ");
                Scanner scanner1 = new Scanner(System.in);
                double m = scanner1.nextDouble();
                spotifySubAccount.addMoney(temporarySubscriber, m);
                subscriberServices();
                break;
            case 3:
                for (Artist artist : spotifySubAccount.getAllArtist())
                    System.out.println(artist.showInfo());
                System.out.println();
                subscriberServices();
                break;
            case 4:
                System.out.println("Enter the name of artist: ");
                artistName = scanner.next();
                System.out.println("Enter the surname of artist: ");
                artistSurname = scanner.next();
                if (spotifyArtistAccount.existsArtistByNameAndSurname(artistName, artistSurname)){
                    for (Song song : spotifySubAccount.getSongsOfArtist(artistName, artistSurname))
                        System.out.println(song.showInfo() + '\n');
                } else
                    System.out.println("Artist with this name do not exists!" + '\n');
                subscriberServices();
                break;
            case 5:
                System.out.println("Enter the name of artist: ");
                artistName = scanner.next();
                System.out.println("Enter the surname of artist: ");
                artistSurname = scanner.next();
                if (spotifyArtistAccount.existsArtistByNameAndSurname(artistName, artistSurname)){
                    spotifyArtistAccount.subscribeToArtist(artistName, artistSurname, temporarySubscriber);
                    System.out.println("You subscribed to " + artistName + "!");
                }
                else
                    System.out.println("Artist with this name do not exists!" + '\n');
                subscriberServices();
                break;
            case 6:
                System.out.println("Enter the name of artist: ");
                artistName = scanner.next();
                System.out.println("Enter the surname of artist: ");
                artistSurname = scanner.next();
                if (spotifyArtistAccount.existsArtistByNameAndSurname(artistName, artistSurname)){
                    spotifyArtistAccount.unsubscribeFromArtist(artistName, artistSurname, temporarySubscriber);
                    System.out.println("You unsubscribed from " + artistName + "!");
                }
                else
                    System.out.println("Artist with this name do not exists!" + '\n');
                subscriberServices();
                break;
            case 7:
                System.out.println("Enter the name of the song: ");
                String songName = scanner.next();
                System.out.println("Enter the name of artist: ");
                artistName = scanner.next();
                System.out.println("Enter the surname of artist: ");
                artistSurname = scanner.next();
                if (spotifyArtistAccount.existsArtistByNameAndSurname(artistName, artistSurname))
                    spotifySubAccount.addSongToPlaylist(temporarySubscriber.getEmail(), songName, artistName, artistSurname);
                else
                    System.out.println("Artist with this name do not exists!" + '\n');
                subscriberServices();
                break;
            case 8:
                System.out.println("Your playlist: ");
                System.out.println(temporarySubscriber.getSongs());
                subscriberServices();
                break;
            case 0:
                break;
        }
    }

    public static void main(String[] args) {

        /**
         * Creating artists by factory
         */
        Song song1 = new EDM(new KPop(new Top10(new Song("Song1", 2020, "description1", "", iFormat))));
        Song song2 = new HipHopAndRap(new Song("Song2", 2020, "description2", "", iFormat));
        Song song3 = new Jazz(new Rock(new Top100(new Song("Song3", 2020, "description3", "", iFormat))));
        Song song4 = new Rock(new Alternative(new Top50(new Song("Song4", 2018, "description4", "", iFormat))));
        Song song5 = new KPop(new Top10(new Song("Song5", 2018, "description5", "", iFormat)));
        Song song6 = new HipHopAndRap(new Rock(new Top50(new Song("Song6", 2021, "description6", "", iFormat))));
        Song song7 = new Soul(new Top10(new Song("Song7", 2021, "description7", "", iFormat)));
        Song song8 = new EDM(new Alternative(new Top50(new Song("Song8", 2020, "description8", "", iFormat))));
        Song song9 = new EDM(new Rock(new Top100(new Song("Song9", 2019, "description9", "", iFormat))));

        SpotifyElements spotifyArtist1 = factory.createSpotifyElement(new Artist("Maksat", "Kuanysh", "maksat@example.com", "qwerty"));
        SpotifyElements spotifyArtist2 = factory.createSpotifyElement(new Artist("Akbala", "Tleugaliyeva", "akbala@example.com", "qwerty"));
        SpotifyElements spotifyArtist3 = factory.createSpotifyElement(new Artist("Olzhas", "Otep", "olzhas@example.com", "qwerty"));

        /**
         * Creating songs by factory
         */
        factory = new SongFactory();
        factory.createSpotifyElement(((Artist) spotifyArtist1).getEmail(), song3);
        factory.createSpotifyElement(((Artist) spotifyArtist2).getEmail(), song9);
        factory.createSpotifyElement(((Artist) spotifyArtist1).getEmail(), song1);
        factory.createSpotifyElement(((Artist) spotifyArtist3).getEmail(), song5);
        factory.createSpotifyElement(((Artist) spotifyArtist3).getEmail(), song7);
        factory.createSpotifyElement(((Artist) spotifyArtist2).getEmail(), song4);
        factory.createSpotifyElement(((Artist) spotifyArtist3).getEmail(), song4);
        factory.createSpotifyElement(((Artist) spotifyArtist2).getEmail(), song7);
        factory.createSpotifyElement(((Artist) spotifyArtist2).getEmail(), song6);

        /**
         * Adding song into artist songlist
         */
        iFormat = new M4AFormat(wavFormat);
        factory.createSpotifyElement(((Artist) spotifyArtist2).getEmail(), song2);
        factory.createSpotifyElement(((Artist) spotifyArtist3).getEmail(), song5);
        factory.createSpotifyElement(((Artist) spotifyArtist1).getEmail(), song8);
        factory.createSpotifyElement(((Artist) spotifyArtist3).getEmail(), song9);

        /**
         * Creating subscribers by factory
         */
        factory = new SubscriberFactory();
        SpotifyElements spotifySub1 = factory.createSpotifyElement(new Subscriber("1111", "1111", "1111", "1111"));

        spotifyArtistAccount.getArtist("akbala@example.com").register((Observer) spotifySub1);
        spotifySubAccount.saveSub((Subscriber) spotifySub1);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choose;

            System.out.println("Are you artist?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            choose = scanner.nextInt();
            if (!(choose == 1 || choose == 2)) {
                System.out.println("Invalid input!");
                continue;
            }

            boolean isLogined = loginAndRegisterSystem(choose == 1);
            if (isLogined && choose == 1)
                artistServices();
            else if (isLogined && choose == 2)
                subscriberServices();
            else
                System.out.println("Error! Invalid login or option choice. Please try again");
        }
    }
}