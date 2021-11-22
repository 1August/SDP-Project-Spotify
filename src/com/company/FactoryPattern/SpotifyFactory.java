package com.company.FactoryPattern;

import com.company.AdapterPattern.AudioFormats.IFormat;
import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;

public interface SpotifyFactory {
//    Придумать общий метод для Artist, Subs, Songs:

//
//    public String showInfoFactory(SpotifyFactory spotifyFactory){
//        String result = '';
//        for(SpotifyFactory spotifyFactory1 : spotifyFactory){
//            res += '\t' + spotifyFactory1.toString + '\n';
//        }
//        return result;
//    }
//    SpotifyElements createSpotifyElement();
    SpotifyElements createSpotifyElement(String artistEmail, Song song);
    SpotifyElements createSpotifyElement(Artist artist);
    SpotifyElements createSpotifyElement(Subscriber subscriber);
}
