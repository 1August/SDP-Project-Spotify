package com.company;

//import com.company.AudioFormats.IFormat;
//import com.company.AudioFormats.MP3Format;
//import com.company.AudioFormats.WAVFormat;
//import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.AudioFormats.IFormat;
import com.company.AudioFormats.MP3Format;
import com.company.AudioFormats.WAVFormat;
import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.DecoratorPattern.SongGenres.HipHopAndRap;
import com.company.DecoratorPattern.SongGenres.KPop;
import com.company.DecoratorPattern.SongRatings.Top10;
import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> genres = new ArrayList<>();
        WAVFormat wavFormat = new WAVFormat();
        IFormat iFormat = new MP3Format(wavFormat);
        iFormat.encode();
        Song song1 = new EDM(new KPop(new Top10(new Song("Song1", 2020, "sdgdsgs", genres, "", iFormat))));
        Song song2 = new HipHopAndRap(new Song("Song2", 2020, "sdgdsgs", genres, "", iFormat));
        Artist artist1 = new Artist("Maksat", "Artist1", "artist1@example.com", "qwerty");
        Artist artist2 = new Artist("Akbala", "Artist2", "artist2@example.com", "qwerty");
        Subscriber subscriber1 = new Subscriber("Subs1", "Subs1", "subs1@example.com", "qwerty");
        System.out.println(song1.toString());
        song1.getFormat().encode();
        System.out.println(song2.toString());
        artist1.register(subscriber1);
        artist2.register(subscriber1);
        artist1.addSong(song1);
        artist2.addSong(song2);
    }
    }

