package com.github.nogueiralegacy.taylorswift.service;

import com.github.nogueiralegacy.taylorswift.domain.Song;

import java.util.Set;

public class GuessTheSongs {
    private final Set<Song> songs;

    public GuessTheSongs(String fileSongsName) {
        this.songs = new LoadSongs(fileSongsName).loadSongs();
    }

    public boolean isMatch(String songName) {
        return songs.stream().anyMatch(song -> song.getName().equalsIgnoreCase(songName));
    }
    
}
