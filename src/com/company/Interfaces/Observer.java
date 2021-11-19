package com.company.Interfaces;

import com.company.Entities.Song;

import java.util.List;

public interface Observer {
    void update(List<Song> songs, String name);
}
