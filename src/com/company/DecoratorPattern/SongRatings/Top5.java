//package com.company.DecoratorPattern.SongRatings;
//
//import com.company.AudioFormats.IFormat;
//import com.company.DecoratorPattern.SongDecorator;
//import com.company.Entities.Song;
//
//import java.util.List;
//
//public class Top5 extends SongDecorator {
//    public Top5(Song song) {
//        super(song);
//    }
//
//    @Override
//    public String getRating() {
//        return super.getRating()+"Top-5";
//    }
//
//    @Override
//    public String getSongName() {
//        return super.getSongName();
//    }
//
//    @Override
//    public int getPublishedYear() {
//        return super.getPublishedYear();
//    }
//
//    @Override
//    public String getDescription() {
//        return super.getDescription();
//    }
//
//    @Override
//    public List<String> getGenres() {
//        return super.getGenres();
//    }
//
//}
