package com.company;

//import com.company.AudioFormats.IFormat;
//import com.company.AudioFormats.MP3Format;
//import com.company.AudioFormats.WAVFormat;
//import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.DecoratorPattern.SongGenres.EDM;
import com.company.DecoratorPattern.SongGenres.HipHopAndRap;
import com.company.DecoratorPattern.SongRatings.Top10;
import com.company.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> genres = new ArrayList<>();
//        Song song = new Song("afa", 2020, "sdgdsgs", genres, "");
//        song.setSongName("safsafsaf");
        Song song1 = new HipHopAndRap(new EDM(new Top10(new Song("afa", 2020, "sdgdsgs", genres, ""))));
        System.out.println(song1.toString());
    }
}
